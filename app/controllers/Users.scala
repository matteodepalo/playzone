package controllers

import play.api._
import play.api.mvc._
import models.User

object Users extends Controller {
  def show(id: Long) = Action {
    val user = User.find(id)

    Ok(views.html.users.show(user))
  }
}
