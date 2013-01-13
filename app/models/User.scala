package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class User(id: Long, name: String, email: String)

object User {
  val parser = {
    get[Long]("id") ~
    get[String]("name") ~
    get[String]("email") map {
      case id~name~email => User(id, name, email)
    }
  }

  def find(id: Long) = DB.withConnection { implicit c =>
    SQL("select * from \"user\" where id = {id}").on(
      'id -> id
    ).as(parser.singleOpt)
  }

  def create(name: String, email: String): Long = {
    DB.withConnection { implicit c =>
      SQL("insert into \"user\" (name, email) values ({name}, {email})").on(
        'name -> name,
        'email -> email
      ).executeInsert(get[Long]("id").single)
    }
  }

  def findByEmail(email: String) = DB.withConnection { implicit c =>
    SQL("select * from \"user\" where email = {email}").on(
      'email -> email
    ).as(parser.singleOpt)
  }
}
