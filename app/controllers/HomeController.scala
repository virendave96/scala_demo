package controllers

import play.api.libs.json.Json
import play.api.mvc._
import service.ItemService

import javax.inject._

/**
 * This class creates the actions and the websocket needed.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, itemService: ItemService)
  extends BaseController {


  // Home page that renders template
  def index = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def test: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    println("Test called")
    val itemReq: model.Request =
      request.body.asJson.get.as[model.Request]
    Results
      .Ok(Json.toJson(itemService.getItemList(itemReq)))
  }

}
