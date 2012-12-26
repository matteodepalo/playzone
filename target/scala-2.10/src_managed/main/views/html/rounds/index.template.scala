
package views.html.rounds

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Round],Form[String],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(rounds: List[Round], roundForm: Form[String]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.48*/("""

"""),_display_(Seq[Any](/*3.2*/main("Rounds")/*3.16*/ {_display_(Seq[Any](format.raw/*3.18*/("""
""")))})))}
    }
    
    def render(rounds:List[Round],roundForm:Form[String]): play.api.templates.Html = apply(rounds,roundForm)
    
    def f:((List[Round],Form[String]) => play.api.templates.Html) = (rounds,roundForm) => apply(rounds,roundForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 12:24:03 CET 2012
                    SOURCE: /Users/matteodepalo/Projects/playzone/app/views/rounds/index.scala.html
                    HASH: 9bdbacdc71ce2567cf1665a6a266bba8af59f7dc
                    MATRIX: 530->1|653->47|690->50|712->64|751->66
                    LINES: 19->1|22->1|24->3|24->3|24->3
                    -- GENERATED --
                */
            