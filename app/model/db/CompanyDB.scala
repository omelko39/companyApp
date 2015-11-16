package model.db

/**
 * Created by nazar on 16.11.15.
 */

import play.api.db.slick.Config.driver.simple._

case class CompanyDB(id: Int, name: String, value: Int, parent: Boolean)

class CompaniesDB(tag: Tag) extends Table[CompanyDB](tag, Some("public"), "company") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def name = column[String]("name", O.NotNull)

  def value = column[Int]("value", O.NotNull)

  def parent = column[Boolean]("parent", O.NotNull)


  override def * = (id, name, value, parent) <> (CompanyDB.tupled, CompanyDB.unapply)
}