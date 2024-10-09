package model

import play.api.libs.json.{Json, OFormat}

case class Request(authKey: String, parem: String)

object Request {
  implicit val jsFormat: OFormat[Request] =
    Json.format[Request]
}