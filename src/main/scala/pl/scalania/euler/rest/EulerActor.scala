package pl.scalania.euler.rest

import akka.actor.Actor
import pl.scalania.euler.Euler04
import spray.http.MediaTypes._
import spray.routing.HttpService
import spray.json._
import DefaultJsonProtocol._ // if you don't supply your own Protocol (see below)

class EulerActor extends Actor with EulerHttpService {

  def actorRefFactory = context

  def receive = runRoute(myRoute)
}

trait EulerHttpService extends HttpService {

  val myRoute =
    path("euler03") {
      get {
        complete {
          "tu nic nie ma"
        }
      }
    } ~
    path("euler04" / IntNumber) { digits => {
       (get | put) {
         val result = pl.scalania.euler.Euler04.largestPalindrome(digits)
          complete {
            result.toJson.prettyPrint
          }
        }
      }
    }
}