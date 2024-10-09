package service

import com.github.tototoshi.csv.CSVReader
import model.{Request, Respond}
import utils.DataMapper

import java.io.File

class ItemService {
  val reader: CSVReader = CSVReader.open(
    new File("./conf/uuid_firstnames_shortemails.csv"))

  def getItemList(request: Request): Respond = {
    Respond(reader.all().drop(1).map(DataMapper.csv2Item).filter(data => data.name.equalsIgnoreCase(request.parem) || data.email.equalsIgnoreCase(request.parem)).take(3), "Success")
  }

}
