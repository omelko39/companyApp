package controllers

import play.api.mvc._
import repository.DefaultCompanyDAOCake
import repository.cake.CompanyDAOCake
import service.DefaultCompanyServiceDAOCake
import service.cake.CompanyServiceDAOCake

//abstract  class Application extends Controller {
//
//  def index()
//
//}

class Application extends Controller {
  val service = new DefaultCompanyServiceDAOCake with DefaultCompanyDAOCake

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def list() = Action {
    Ok("nice = " +  service.companyDAO.list().toString())
  }

  def delete(id: Int) = Action {
    service.companyDAO.deleteByPK(id) match {
      case true => Ok("ok = " + service.companyDAO.list().toString())
      case false => BadRequest(service.companyDAO.list().toString())
    }
  }
}

