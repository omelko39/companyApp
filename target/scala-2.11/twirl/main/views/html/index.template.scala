
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*6.17*/message),format.raw/*6.24*/("""</title>
        <script src=""""),_display_(/*7.23*/routes/*7.29*/.Assets.at("lib/angularjs/angular.js")),format.raw/*7.67*/(""""></script>
        <script src=""""),_display_(/*8.23*/routes/*8.29*/.Assets.at("javascripts/hello.js")),format.raw/*8.63*/(""""></script>
    </head>
    <body ng-app="App" ng-controller="Main">
        <button data-ng-click="pl = true">+</button>
        <div ng-show="pl == true">
            Name:<input type="text" ng-model="tmp.name">
            Value:<input type="number" ng-model="tmp.value">
        </div>

        <button data-ng-click="create(undefined, tmp); pl = false">save</button>
        <h1>*----------------------------*</h1>

        <ng-include src="'assets/include.html'"></ng-include>
    </body>
</html>

"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Nov 17 14:14:21 EET 2015
                  SOURCE: /projects/Company/app/views/index.scala.html
                  HASH: 22e4959984296958ffc6baeb48b9591b464eac06
                  MATRIX: 505->1|610->18|637->19|714->70|741->77|798->108|812->114|870->152|930->186|944->192|998->226
                  LINES: 19->1|22->1|23->2|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8
                  -- GENERATED --
              */
          