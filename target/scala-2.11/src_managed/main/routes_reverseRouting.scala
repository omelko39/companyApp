// @SOURCE:/projects/Company/conf/routes
// @HASH:ae451257895598dca765c7ebd876aa40d8984c06
// @DATE:Tue Nov 17 13:24:33 EET 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:6
package controllers {

// @LINE:9
class ReverseAssets {


// @LINE:9
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:6
class ReverseApplication {


// @LINE:17
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "create")
}
                        

// @LINE:13
def delete(id:Int): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "delete/" + implicitly[PathBindable[Int]].unbind("id", id))
}
                        

// @LINE:11
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "list")
}
                        

// @LINE:15
def update(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "update")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:9
class ReverseAssets {


// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:6
class ReverseApplication {


// @LINE:17
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "create"})
      }
   """
)
                        

// @LINE:13
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.delete",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delete/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:11
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "list"})
      }
   """
)
                        

// @LINE:15
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "update"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:9
class ReverseAssets {


// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:17
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:6
class ReverseApplication {


// @LINE:17
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "create", Seq(), "POST", """""", _prefix + """create""")
)
                      

// @LINE:13
def delete(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "delete", Seq(classOf[Int]), "GET", """""", _prefix + """delete/$id<[^/]+>""")
)
                      

// @LINE:11
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "list", Seq(), "GET", """""", _prefix + """list""")
)
                      

// @LINE:15
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "update", Seq(), "POST", """""", _prefix + """update""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    