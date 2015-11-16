package repository


import model._
import model.db.{Childs, CompaniesDB, CompanyDB}
import play.api.db.slick.Config.driver.simple._
import cake.CompanyDAOCake

import scala.slick.jdbc.{GetResult, StaticQuery => Q}

/**
 * Created by andrew-stefaniv on 24.07.15.
 */
trait DefaultCompanyDAOCake extends CompanyDAOCake {

  override def companyDaoDB = new DefaultCompanyDAO

  class DefaultCompanyDAO extends CompanyDAO {
    val query = TableQuery[CompaniesDB]
    val child = TableQuery[Childs]

    override def deleteByPK(id: Int): Boolean = withSession { implicit s =>
      query.filter(_.id === id).delete
      child.filter(_.child === id).delete == 1
    }

    override def deleteByPKs(ids: Traversable[Int]): Traversable[Int] = withSession { implicit s =>
      ids.map { id =>
        query.filter(_.id === id).delete
      }
    }

    override def updateByObjects(objs: Traversable[CompanyDB]): Traversable[CompanyDB] = withSession { implicit s =>
      objs.map { obj =>
        if (query.filter(_.id === obj.id).update(obj) == 1)
         obj
        else
          throw new ModelExceptions("cannot delete obj")
      }

    }

    override def updateByObject(obj: CompanyDB): Boolean = withSession { implicit s =>
      query.filter(_.id === obj.id).update(obj) == 1
    }

    override def insertByObjects(objs: Traversable[CompanyDB]): Traversable[CompanyDB] = withSession { implicit s =>
      (for (obj <- objs) yield {
        Some((query returning query) += obj)
      }).flatMap(i => i)
    }

    override def insertByObject(obj: CompanyDB): Option[CompanyDB] = withSession { implicit s =>
      Some((query returning query) += obj)
    }

    override def loadByPKs(ids: Traversable[Int]): List[CompanyDB] = withSession { implicit s =>
      query.filter(_.id inSet ids).list
    }

    override def loadByPK(id: Int): Option[CompanyDB] = withSession { implicit s =>
      query.filter(_.id === id).list.headOption
    }

    override def getChild(id: Int): Traversable[Option[CompanyDB]] = withSession { implicit s =>
      child.filter(_.parent === id).map(_.child).list.map{ id =>
        query.filter(_.id === id).list.headOption
      }
    }

    override def list(): Traversable[CompanyDB] = withSession { implicit s =>
      query.filter(_.parent === true).list
    }
  }

}

trait MockCompanyDAOCake extends CompanyDAOCake {

}