package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Round

object Rounds extends Controller {
  val roundForm = Form(
    "game_id" -> longNumber
  )

  def index = Action {
    Ok(views.html.rounds.index(Round.all()))
  }

  def build = Action {
    Ok(views.html.rounds.build(roundForm))
  }
  
  def create = Action { implicit request =>
    roundForm.bindFromRequest.fold(
      errors => BadRequest(views.html.rounds.build(errors)),
      game_id => {
        Round.create(game_id)
        Redirect(routes.Rounds.index)
      }
    )
  }
  
  def destroy(id: Long) = Action {
    Round.delete(id)
    Redirect(routes.Rounds.index)
  }
}