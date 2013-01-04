package models

import anorm._
import anorm.SqlParser._
import play.api.PlayException
import play.api.db._
import play.api.Play.current

case class Round(id: Long, game_id: Long) {
  def game = {
    Game.find(this.game_id)
  }
  
  def destroy = {
    Round.delete(this.id)
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
  
  def find(id: Long) = DB.withConnection { implicit c => 
    SQL("select * from round where id = {id}").on(
      'id -> id
    ).as(parser.single)
  }

  def create(game_id: Long): Long = {
    DB.withConnection { implicit c =>
      SQL("insert into round (game_id) values ({game_id})").on(
        'game_id -> game_id
      ).executeInsert() match {
        case Some(long) => long
        case None => throw new PlayException("Error creating round", "There was a problem creating the round");
      }
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