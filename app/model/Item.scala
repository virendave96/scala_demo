package model

import play.api.libs.json.{Json, OFormat}

import java.util.UUID

case class Item(id: UUID, name: String, email: String)

object Item {
  implicit val jsFormat: OFormat[Item] =
    Json.format[Item]
}