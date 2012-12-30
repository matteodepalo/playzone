package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Game(id: Long, name: String)

object Game {
  val game = {
    get[Long]("id") ~ 
    get[String]("name") map {
      case id~name => Game(id, name)
    }
  }

  def all(): List[Game] = DB.withConnection { implicit c =>
    SQL("select * from game").as(game *)
  }

  def find(id: Long) = DB.withConnection { implicit c => 
    SQL("select * from game where id = {id}").on(
      'id -> id
    ).as(game.single)
  }

  def create(name: String) {
    DB.withConnection { implicit c =>
      SQL("insert into game (name) values ({name})").on(
        'name -> name
      ).executeUpdate()
    }
  }

  def delete(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from game where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }
}