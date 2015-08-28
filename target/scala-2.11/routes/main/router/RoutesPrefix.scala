
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bbordol/GitRepos/MyRepo/conf/routes
// @DATE:Fri Aug 28 16:27:09 PDT 2015


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
