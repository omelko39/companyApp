package repository


import org.postgresql.util.PSQLException
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB

/**
 * Created by aleo on 23.07.15.
 */
class ModelExceptions(message: String, rawMessage: String, cause: Throwable) extends Exception(message, cause) {

  def this(message: String, rawMessage: String) = this(message, rawMessage, null)

  def this(rawMessage: String) = this(null, rawMessage, null)

}

package object cakes {

  trait SessionCake {

    private def createCustomException(e: PSQLException) = {
      val rawMessage = e.getMessage + "\n" + e.getStackTrace.map( i => i.toString).mkString("\n")
      e.getSQLState match {
        case "39004" => throw new ModelExceptions("cannot be null value", rawMessage, e.getCause)
        case "23505" => throw new ModelExceptions("field must be unique", rawMessage, e.getCause)
        case "42830" => throw new ModelExceptions("invalid foreign key", rawMessage, e.getCause)
        case _ => e.printStackTrace()
          throw new ModelExceptions(s"Unknown error SQLState: ${e.getSQLState}", rawMessage, e.getCause)
      }
    }

    def withSession[T](f: Session => T): T = DB withSession { s =>
      try {
        f(s)
      } catch {
        case e: PSQLException =>
          createCustomException(e)
      }
    }

    def withDynSession[T](f: Unit => T): T = DB withDynSession {
      try {
        f(Unit)
      } catch {
        case e: PSQLException =>
          createCustomException(e)
      }
    }

    def withTransaction[T](f: Session => T): T = DB withTransaction { s => try {
      f(s)
    } catch {
      case e: PSQLException =>
        createCustomException(e)
    }
    }

    def withDynTransaction[T](f: Unit => T): T = DB withDynTransaction {
      try {
        f(Unit)
      } catch {
        case e: PSQLException =>
          createCustomException(e)
      }
    }
  }

  trait LoadCake[Result, PK] {

    def loadByPK(id: PK): Option[Result]

    def loadByPKs(ids: Traversable[PK]): List[Result]
  }

  trait DeleteCake[T, PK] {

    def deleteByPK(id: PK): Boolean

    def deleteByPKs(ids: Traversable[PK]): Traversable[PK]
  }

  trait UpdateCake[T] {

    def updateByObject(obj: T): Boolean

    def updateByObjects(objs: Traversable[T]): Traversable[T]
  }

  trait InsertCake[T] {

    def insertByObject(obj: T): Option[T]

    def insertByObjects(objs: Traversable[T]): Traversable[T]
  }




}
