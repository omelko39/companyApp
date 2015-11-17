package controllers

import model.Company
import play.api.Logger
import play.api.mvc._
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._
import play.api.libs.json._
import repository.DefaultCompanyDAOCake
import repository.cake.CompanyDAOCake
import service.DefaultCompanyServiceDAOCake
import service.cake.CompanyServiceDAOCake

import scala.collection.mutable.ListBuffer

//abstract  class Application extends Controller {
//
//  def index()
//
//}


class Application extends Controller {
  val service = new DefaultCompanyServiceDAOCake with DefaultCompanyDAOCake

  implicit val companyWrites = Json.writes[Company]
  implicit val companyRead: Reads[Company] = (
    (JsPath \ "id").readNullable[Int] and
      (JsPath \ "name").read[String] and
      (JsPath \ "value").read[Int].orElse(Reads.pure(0)) and
      (JsPath \ "fullValue").read[Int].orElse(Reads.pure(0)) and
      (JsPath \ "list").read[ListBuffer[Company]].orElse(Reads.pure(ListBuffer.empty[Company])) and
      (JsPath \ "parent").read[Boolean]
    ) (Company.apply _)

  implicit val companyReads: Reads[(Company, Option[Int])] = (
    (JsPath \ "id").readNullable[Int] and
    (JsPath \ "name").read[String] and
    (JsPath \ "parent").read[Boolean] and
    (JsPath \ "parentId").readNullable[Int] and
    (JsPath \ "value").read[Int].orElse(Reads.pure(0)) and
    (JsPath \ "fullValue").read[Int].orElse(Reads.pure(0)) and
    (JsPath \ "list").read[ListBuffer[Company]].orElse(Reads.pure(ListBuffer.empty[Company]))
  )((p_1: Option[Int], p_2: String, p_3: Boolean, p_4: Option[Int], p_5: Int, p_6: Int, p_7: ListBuffer[Company]) =>
      (Company(p_1, p_2, p_5, p_6, p_7, p_3), p_4))


  def index = Action {
    Ok(views.html.index("Hello"))
  }

  def list() = Action {
    Ok(Json.toJson(service.companyDAO.list()))
  }

  def delete(id: Int) = Action {
    service.companyDAO.deleteByPK(id) match {
      case true => Ok("ok = " + service.companyDAO.list().toString())
      case false => BadRequest(service.companyDAO.list().toString())
    }
  }

  def create = Action {
    request =>
      request.body.asJson.map {
        json =>
          json.validate(companyReads) match {
            case s: JsSuccess[(Company, Option[Int])] =>
              service.companyDAO.insertByObject(s.get._1, s.get._2)
              Ok(Json.toJson(service.companyDAO.list()))
            case e: JsError => BadRequest(e.toString)
          }
      }.get
  }

  def update = Action {
    request =>
      request.body.asJson match {
        case Some(json) => {
          Logger.debug(json.toString())
          json.validate(companyRead) match {
            case s: JsSuccess[Company] =>
              service.companyDAO.updateByObject(s.get)
              Ok(Json.toJson(service.companyDAO.list()))

            case e: JsError =>
              Logger.debug(e.toString)
              BadRequest(e.toString)
          }
        }
        case None => BadRequest("No Json")
      }
  }
}

