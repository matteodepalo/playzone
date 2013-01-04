package test

import anorm._
import play.api.db._
import play.api.Play.current
import play.api.test._
import play.api.test.Helpers._

object Helpers extends org.specs2.mutable.Specification {
  def testDB[T](test: => T) = {
    running(FakeApplication()) {
      DB.withConnection {
        implicit connection =>
        SQL("delete from round").execute()
        SQL("delete from game").execute()
      }
      
      test
    }
  }
}