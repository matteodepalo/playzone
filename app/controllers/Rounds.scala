package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Round

object Rounds extends Controller {
  val roundForm = Form(
    "game" -> nonEmptyText
  )

  def rounds = Action {
    Ok(views.html.rounds.index(Round.all(), roundForm))
  }
  
  def newRound = Action { implicit request =>
    roundForm.bindFromRequest.fold(
      errors => BadRequest(views.html.rounds.index(Round.all(), errors)),
      label => {
        Round.create(label)
        Redirect(routes.Rounds.rounds)
      }
    )
  }
  
  def deleteRound(id: Long) = Action {
    Round.delete(id)
    Redirect(routes.Rounds.rounds)
  }
}