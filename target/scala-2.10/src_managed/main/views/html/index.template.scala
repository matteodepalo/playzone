
package views.html

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("Playzone")/*1.18*/ {_display_(Seq[Any](format.raw/*1.20*/("""
  <div class="visual">
    <h1>Find matches for the games you love around you!</h1>
    
    <a class="btn btn-large btn-success" href=""""),_display_(Seq[Any](/*5.49*/routes/*5.55*/.Rounds.rounds)),format.raw/*5.69*/("""">Sign up today</a>
  </div>
""")))})))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 12:24:03 CET 2012
                    SOURCE: /Users/matteodepalo/Projects/playzone/app/views/index.scala.html
                    HASH: 6dae12cd060396ca291ed96b1c5bb7ed19b8add3
                    MATRIX: 578->1|602->17|641->19|814->157|828->163|863->177
                    LINES: 22->1|22->1|22->1|26->5|26->5|26->5
                    -- GENERATED --
                */
            