package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Round(id: Long, game: String)

object Round {
  val round = {
    get[Long]("id") ~ 
    get[String]("game") map {
      case id~game => Round(id, game)
    }
  }

  def all(): List[Round] = DB.withConnection { implicit c =>
    SQL("select * from round").as(round *)
  }

  def create(game: String) {
    DB.withConnection { implicit c =>
      SQL("insert into round (game) values ({game})").on(
        'game -> game
      ).executeUpdate()
    }
  }

  def delete(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from round where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }
}