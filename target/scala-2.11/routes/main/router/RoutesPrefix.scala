
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/bbordol/GitRepos/shs-platform-play/conf/routes
// @DATE:Wed Aug 19 11:56:28 PDT 2015


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
