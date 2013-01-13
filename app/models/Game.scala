package models

import anorm._
import anorm.SqlParser._
import play.api.PlayException
import play.api.db._
import play.api.Play.current

case class Game(id: Long, name: String) {
  def destroy() {
    Game.destroy(this.id)
  }
}

object Game {
  val parser = {
    get[Long]("id") ~ 
    get[String]("name") map {
      case id~name => Game(id, name)
    }
  }

  def all(): List[Game] = DB.withConnection { implicit c =>
    SQL("select * from game").as(parser *)
  }

  def find(id: Long) = DB.withConnection { implicit c => 
    SQL("select * from game where id = {id}").on(
      'id -> id
    ).as(parser.singleOpt)
  }

  def create(name: String): Long = {
    DB.withConnection { implicit c =>
      SQL("insert into game (name) values ({name})").on(
        'name -> name
      ).executeInsert((get[Long]("id").single))
    }
  }

  def destroy(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from game where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }
}