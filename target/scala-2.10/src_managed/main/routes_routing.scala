// @SOURCE:/Users/matteodepalo/Projects/playzone/conf/routes
// @HASH:299c488dd708f7918d2a8ba9f1482721898f373a
// @DATE:Wed Dec 26 13:57:10 CET 2012


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Rounds_rounds1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rounds"))))
        

// @LINE:10
private[this] lazy val controllers_Rounds_newRound2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rounds"))))
        

// @LINE:11
private[this] lazy val controllers_Rounds_deleteRound3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rounds/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
        

// @LINE:14
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+"""))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rounds""","""controllers.Rounds.rounds"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rounds""","""controllers.Rounds.newRound"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rounds/$id<[^/]+>/delete""","""controllers.Rounds.deleteRound(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Rounds_rounds1(params) => {
   call { 
        invokeHandler(controllers.Rounds.rounds, HandlerDef(this, "controllers.Rounds", "rounds", Nil,"GET", """ Tasks          """, Routes.prefix + """rounds"""))
   }
}
        

// @LINE:10
case controllers_Rounds_newRound2(params) => {
   call { 
        invokeHandler(controllers.Rounds.newRound, HandlerDef(this, "controllers.Rounds", "newRound", Nil,"POST", """""", Routes.prefix + """rounds"""))
   }
}
        

// @LINE:11
case controllers_Rounds_deleteRound3(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Rounds.deleteRound(id), HandlerDef(this, "controllers.Rounds", "deleteRound", Seq(classOf[Long]),"POST", """""", Routes.prefix + """rounds/$id<[^/]+>/delete"""))
   }
}
        

// @LINE:14
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        