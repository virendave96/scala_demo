package controllers

import actor.MyWebSocketActor
import akka.actor.ActorSystem
import akka.stream.Materializer
import play.api.libs.json.JsValue
import play.api.libs.streams.ActorFlow
import play.api.mvc._

import javax.inject.{Inject, Singleton}

//implicit val inEventFormat  = Json.format[InEvent]
//implicit val outEventFormat = Json.format[OutEvent]

@Singleton
class Application @Inject()(cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer)
  extends AbstractController(cc) {
  def socket = WebSocket.accept[JsValue, JsValue] { request =>
    println(request.toString())

    //    request.headers.get("secretKey") match {
    //      case None =>
    //        println("getNoHeader")
    //        ActorFlow.actorRef { out =>
    //          MyWebSocketActor.props(out)
    //        }
    //      case Some(_) =>
    //        println("getHeader")
    //        ActorFlow.actorRef { out =>
    //          MyWebSocketActor.props(out)
    //        }
    //    }
    //  }
    ActorFlow.actorRef { out =>
      MyWebSocketActor.props(out)
    }
  }
}