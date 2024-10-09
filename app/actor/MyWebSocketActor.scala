package actor

import akka.actor._
import model.{Request, Respond}
import play.api.libs.json.{JsValue, Json}
import service.ItemService

object MyWebSocketActor {
  def props(out: ActorRef): Props = Props(new MyWebSocketActor(out))

  val hardCodeKeyString = "kjjhyfhbddrtggdd"
}

class MyWebSocketActor(out: ActorRef) extends Actor {

  def receive: Receive = {
    case msg: String =>
      println("test socket " + msg)
      out ! ("I received your message: " + msg)
    case msg: JsValue =>
      println("test socket " + msg)
      val request = msg.as[Request]
      if (MyWebSocketActor.hardCodeKeyString == request.authKey) {
        val itemService: ItemService = new ItemService
        val itemLs: Respond = itemService.getItemList(request)
        out ! (Json.toJson(itemLs))
      } else {
        out ! (Json.toJson(Respond(Seq(), "Invalid AuthKey")))
      }


  }
}