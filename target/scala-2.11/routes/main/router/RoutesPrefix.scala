
// @GENERATOR:play-routes-compiler
// @SOURCE:/projects/Company/conf/routes
// @DATE:Mon Nov 16 16:02:25 EET 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
