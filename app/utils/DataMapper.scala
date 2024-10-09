package utils

import model.Item

import java.util.UUID

object DataMapper {


  val csv2Item: List[String] => Item = (csvData: List[String]) => Item(id = UUID.fromString(csvData.head), name = csvData.apply(1), email = csvData.apply(2))

}
