package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Round(id: Long, game_id: Long) {
  def game = {
    Game.find(this.game_id)
  }
}

object Round {
  val parser = {
    get[Long]("id") ~ 
    get[Long]("game_id") map {
      case id~game_id => Round(id, game_id)
    }
  }

  def all(): List[Round] = DB.withConnection { implicit c =>
    SQL("select * from round").as(parser *)
  }

  def create(game_id: Long) {
    DB.withConnection { implicit c =>
      SQL("insert into round (game_id) values ({game_id})").on(
        'game_id -> game_id
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