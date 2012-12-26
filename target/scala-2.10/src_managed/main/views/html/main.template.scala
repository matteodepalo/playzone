
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
  <head>
    <title>"""),_display_(Seq[Any](/*7.13*/title)),format.raw/*7.18*/("""</title>
    <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*8.55*/routes/*8.61*/.Assets.at("images/favicon.png"))),format.raw/*8.93*/("""">
    <script src=""""),_display_(Seq[Any](/*9.19*/routes/*9.25*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*9.70*/("""" type="text/javascript"></script>
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.50*/routes/*10.56*/.Assets.at("stylesheets/bootstrap/bootstrap.min.css"))),format.raw/*10.109*/("""" />
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*11.50*/routes/*11.56*/.Assets.at("stylesheets/bootstrap/bootstrap-responsive.min.css"))),format.raw/*11.120*/("""" />
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*12.50*/routes/*12.56*/.Assets.at("stylesheets/main.css"))),format.raw/*12.90*/("""" />
  </head>
  <body>
    <div class="container">
      <div class="masthead">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">About</a></li>
          <li><a href="#">Contact</a></li>
        </ul>
        <h3 class="muted">Playzone</h3>
      </div>

      <hr>

      """),_display_(Seq[Any](/*27.8*/content)),format.raw/*27.15*/("""

      <div class="footer">
        <p>&copy; Playzone 2012</p>
      </div>
    </div>
  </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.Html = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 26 12:39:29 CET 2012
                    SOURCE: /Users/matteodepalo/Projects/playzone/app/views/main.scala.html
                    HASH: c0a8700ebdef888c922c5858c5bf1545f9241998
                    MATRIX: 509->1|616->31|698->78|724->83|822->146|836->152|889->184|945->205|959->211|1025->256|1145->340|1160->346|1236->399|1326->453|1341->459|1428->523|1518->577|1533->583|1589->617|1977->970|2006->977
                    LINES: 19->1|22->1|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|48->27|48->27
                    -- GENERATED --
                */
            