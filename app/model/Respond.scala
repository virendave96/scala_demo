package model

import play.api.libs.json.{Json, OFormat}

case class Respond(items: Seq[Item], message: String)

object Respond {
  implicit val jsFormat: OFormat[Respond] =
    Json.format[Respond]
}