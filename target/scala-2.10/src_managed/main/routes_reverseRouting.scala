// @SOURCE:/Users/matteodepalo/Projects/playzone/conf/routes
// @HASH:299c488dd708f7918d2a8ba9f1482721898f373a
// @DATE:Wed Dec 26 12:39:29 CET 2012

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseRounds {
    

// @LINE:11
def deleteRound(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rounds/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                

// @LINE:10
def newRound(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rounds")
}
                                                

// @LINE:9
def rounds(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rounds")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:14
class ReverseAssets {
    

// @LINE:14
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseRounds {
    

// @LINE:11
def deleteRound : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Rounds.deleteRound",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rounds/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:10
def newRound : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Rounds.newRound",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rounds"})
      }
   """
)
                        

// @LINE:9
def rounds : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Rounds.rounds",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rounds"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

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
              

// @LINE:14
class ReverseAssets {
    

// @LINE:14
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseRounds {
    

// @LINE:11
def deleteRound(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Rounds.deleteRound(id), HandlerDef(this, "controllers.Rounds", "deleteRound", Seq(classOf[Long]), "POST", """""", _prefix + """rounds/$id<[^/]+>/delete""")
)
                      

// @LINE:10
def newRound(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Rounds.newRound(), HandlerDef(this, "controllers.Rounds", "newRound", Seq(), "POST", """""", _prefix + """rounds""")
)
                      

// @LINE:9
def rounds(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Rounds.rounds(), HandlerDef(this, "controllers.Rounds", "rounds", Seq(), "GET", """ Tasks          """, _prefix + """rounds""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:14
class ReverseAssets {
    

// @LINE:14
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      