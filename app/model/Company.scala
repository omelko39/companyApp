package model


import scala.collection.mutable.ListBuffer

/**
 * Created by nazar on 16.11.15.
 */
case class Company(id: Option[Int], name: String, value: Int, fullValue: Int, list: ListBuffer[Company], parent: Boolean)

