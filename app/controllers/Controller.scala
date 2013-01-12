package controllers

import play.api.mvc._
import play.api.Play
import models.User

trait Controller extends play.api.mvc.Controller {
  val adminPassword = Play.current.configuration.getString("adminPassword").getOrElse("1234secret")

  def currentUser(implicit request: RequestHeader): Option[User] =
    Option(User.find(session.get("user_id").map(_.toLong).get))

  def Secured[A](username: String, password: String)(action: Action[A]) = Action(action.parser) { request =>
    request.headers.get("Authorization").flatMap { authorization =>
      authorization.split(" ").drop(1).headOption.filter { encoded =>
        new String(org.apache.commons.codec.binary.Base64.decodeBase64(encoded.getBytes)).split(":").toList match {
          case u :: p :: Nil if u == username && password == p => true
          case _ => false
        }
      }.map(_ => action(request))
    }.getOrElse {
      Unauthorized.withHeaders("WWW-Authenticate" -> "Basic realm=\"Secured\"")
    }
  }
}