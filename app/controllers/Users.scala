package controllers

import play.api._
import play.api.mvc._
import models.User

object Users extends Controller {
  def show(id: Long) = Action {
    User.find(id).map { user =>
      Ok(views.html.users.show(user))
    }.getOrElse(NotFound)
  }
}
