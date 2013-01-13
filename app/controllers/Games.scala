package controllers

import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Game

object Games extends Controller {
  val gameForm = Form(
    "name" -> nonEmptyText
  )

  def build = Secured("admin", adminPassword) {
    Action { implicit request =>
      Ok(views.html.games.build(gameForm))
    }
  }

  def create = Secured("admin", adminPassword) {
    Action { implicit request =>
      gameForm.bindFromRequest.fold(
        errors => BadRequest(views.html.games.build(errors)),
        name => {
          Game.create(name)
          Redirect(routes.Rounds.index())
        }
      )
    }
  }
}