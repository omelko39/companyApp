package service

import model.Company
import model.db.{CompanyDB}
import repository.cake.CompanyDAOCake
import service.cake.CompanyServiceDAOCake

import scala.collection.mutable.ListBuffer

/**
 * Created by nazar on 16.11.15.
 */

trait DefaultCompanyServiceDAOCake extends CompanyServiceDAOCake {
  this: CompanyDAOCake  =>

  def companyDAO: CompanyServiceDAO = new DefaultCompanyServiceDAO

  class DefaultCompanyServiceDAO extends CompanyServiceDAO {

    def fillCompany(company: CompanyDB) = {
      val list  = ListBuffer.empty[Company]
      list ++= companyDaoDB.getChild(company.id).filter(el => el.isDefined).map(obj => loadByPK(obj.get.id))

      Company(
      company.id,
      company.name,
      company.value,
      company.value + list.map(el => el.fullValue).sum,
      list,
      company.parent
      )
    }

    def companyToCompanyDB(company: Company) = CompanyDB(company.id, company.name, company.value, company.parent)

    override def loadByPK(id: Int): Company = {
      fillCompany(companyDaoDB.loadByPK(id).get)
    }

    override def loadByPKs(ids: Traversable[Int]): List[Company] = ???

    override def deleteByPKs(ids: Traversable[Int]): Traversable[Int] = ???

    override def deleteByPK(id: Int): Boolean = {
      companyDaoDB.loadByPK(id) map (company =>
           companyDaoDB.getChild(company.id).filter(el => el.isDefined).map(el => deleteByPK(el.get.id)).exists(el => !el) match {
             case true => companyDaoDB.deleteByPK(id)
             case false => false
           }
        ) get
    }

    override def updateByObjects(objs: Traversable[Company]): Traversable[Company] = ???

    override def updateByObject(obj: Company): Boolean = {
      companyDaoDB.updateByObject(companyToCompanyDB(obj))
    }

    override def insertByObjects(objs: Traversable[Company]): Traversable[Company] = ???

    override def insertByObject(obj: Company): Option[Company] = Some(fillCompany(companyDaoDB.insertByObject(companyToCompanyDB(obj)).get))

    override def list(): List[Company] = {
      companyDaoDB.list().map(fillCompany).toList
    }
  }

}

trait MockCompanyServiceDAOCake extends  CompanyServiceDAOCake {

}

