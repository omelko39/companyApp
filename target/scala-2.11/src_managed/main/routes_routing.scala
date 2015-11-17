// @SOURCE:/projects/Company/conf/routes
// @HASH:ae451257895598dca765c7ebd876aa40d8984c06
// @DATE:Tue Nov 17 13:24:33 EET 2015


import scala.language.reflectiveCalls
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:11
private[this] lazy val controllers_Application_list2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("list"))))
private[this] lazy val controllers_Application_list2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "list", Nil,"GET", """""", Routes.prefix + """list"""))
        

// @LINE:13
private[this] lazy val controllers_Application_delete3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delete/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_delete3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).delete(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "delete", Seq(classOf[Int]),"GET", """""", Routes.prefix + """delete/$id<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_Application_update4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update"))))
private[this] lazy val controllers_Application_update4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).update,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "update", Nil,"POST", """""", Routes.prefix + """update"""))
        

// @LINE:17
private[this] lazy val controllers_Application_create5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("create"))))
private[this] lazy val controllers_Application_create5_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).create,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "create", Nil,"POST", """""", Routes.prefix + """create"""))
        
def documentation = List(("""GET""", prefix,"""@controllers.Application@.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """list""","""@controllers.Application@.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delete/$id<[^/]+>""","""@controllers.Application@.delete(id:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update""","""@controllers.Application@.update"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """create""","""@controllers.Application@.create""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index)
   }
}
        

// @LINE:9
case controllers_Assets_at1_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:11
case controllers_Application_list2_route(params) => {
   call { 
        controllers_Application_list2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).list())
   }
}
        

// @LINE:13
case controllers_Application_delete3_route(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_Application_delete3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).delete(id))
   }
}
        

// @LINE:15
case controllers_Application_update4_route(params) => {
   call { 
        controllers_Application_update4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).update)
   }
}
        

// @LINE:17
case controllers_Application_create5_route(params) => {
   call { 
        controllers_Application_create5_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).create)
   }
}
        
}

}
     