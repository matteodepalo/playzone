package unit

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import models._
import test.Helpers._

class RoundSpec extends Specification {
  "Round" should {
    "create a new round" in testDB {
      Round.all() must have size(0)
      val game_id = Game.create("Dota")
      Round.create(game_id)

      Round.all() must have size(1)
    }
    
    "find all of the rounds" in testDB {
       val game_id = Game.create("Dota")
       val round_id = Round.create(game_id)
        
      Round.all().head must equalTo(Round.find(round_id))
    }
    
    "delete a round" in testDB {
      val game_id = Game.create("Dota")
      val round_id = Round.create(game_id)
      Round.all() must have size(1)
      Round.find(round_id).destroy

      Round.all() must have size(0)
    }
  }
}