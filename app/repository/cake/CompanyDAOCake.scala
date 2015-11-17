package repository.cake

import model.db.{CompanyDB}
import repository.cakes._

/**
 * Created by nazar on 16.11.15.
 */
trait CompanyDAOCake {

  def companyDaoDB: CompanyDAO

  trait CompanyDAO extends SessionCake
  with LoadCake[CompanyDB, Int]
  with DeleteCake[CompanyDB, Int]
  with UpdateCake[CompanyDB]
  with InsertCake[CompanyDB] {
    def getChild(id: Int): Traversable[Option[CompanyDB]]
    def list(): Traversable[CompanyDB]
    def insertChild(childId: Int, parentId: Int): Boolean
    def deleteChild(childId: Int): Boolean
    def deleteParent(parentId: Int): Boolean
  }

}