
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object techroutes_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class techroutes extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(routes: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""

"""),format.raw/*3.1*/("""Here are the routes: <br/>

</br>
<div id="routes">
 """),_display_(/*7.3*/routes),format.raw/*7.9*/("""
"""),format.raw/*8.1*/("""</div>"""))
      }
    }
  }

  def render(routes:String): play.twirl.api.HtmlFormat.Appendable = apply(routes)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (routes) => apply(routes)

  def ref: this.type = this

}


}

/**/
object techroutes extends techroutes_Scope0.techroutes
              /*
                  -- GENERATED --
                  DATE: Fri Aug 28 16:18:38 PDT 2015
                  SOURCE: /Users/bbordol/activator-dist-1.3.5/test-app/app/views/techroutes.scala.html
                  HASH: d67cd56618a584b5d1a01a4c5974895b21507964
                  MATRIX: 755->1|866->17|894->19|973->73|998->79|1025->80
                  LINES: 27->1|32->1|34->3|38->7|38->7|39->8
                  -- GENERATED --
              */
          