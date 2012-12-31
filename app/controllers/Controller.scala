package controllers

import play.api.mvc._
import play.api.Play

trait Controller extends play.api.mvc.Controller {
  val adminPassword = Play.current.configuration.getString("adminPassword") match {
    case Some(x) => x
    case None => "1234secret" 
  }

  def Secured[A](username: String, password: String)(action: Action[A]) = Action(action.parser) { request =>
    request.headers.get("Authorization").flatMap { authorization =>
      authorization.split(" ").drop(1).headOption.filter { encoded =>
        new String(org.apache.commons.codec.binary.Base64.decodeBase64(encoded.getBytes)).split(":").toList match {
          case u :: p :: Nil if u == username && password == p => true
          case _ => false
        }
      }.map(_ => action(request))
    }.getOrElse {
      Unauthorized.withHeaders("WWW-Authenticate" -> """Basic realm="Secured"""")
    }
  }
}