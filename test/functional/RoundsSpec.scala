package functional

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import models.Game
import models.Round

class RoundsSpec extends Specification {
  "Rounds" should {
    "render the index page" in {
      running(FakeApplication()) {
        val page = routeAndCall(FakeRequest(GET, "/rounds")).get
        
        status(page) must equalTo(OK)
        contentType(page) must beSome.which(_ == "text/html")
        contentAsString(page) must contain ("List of Rounds")
      }
    }
    
    "display a created round" in {
      running(FakeApplication()) {
        Game.create("Dota")
        Round.create(Game.all().head.id)
        val page = routeAndCall(FakeRequest(GET, "/rounds")).get
        
        contentAsString(page) must contain ("Dota")
      }
    }
  }
}