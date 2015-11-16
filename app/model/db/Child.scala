package model.db

import play.api.db.slick.Config.driver.simple._


/**
 * Created by nazar on 16.11.15.
 */

case class ChildDB(id: Int, parent: Int, child: Int)

class Childs(tag: Tag) extends Table[ChildDB](tag, Some("public"), "child") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def parent = column[Int]("parent", O.NotNull)

  def child = column[Int]("child", O.NotNull)

  override def * = (id, parent, child) <> (ChildDB.tupled, ChildDB.unapply)
}
