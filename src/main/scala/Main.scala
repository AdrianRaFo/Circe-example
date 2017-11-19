
import io.circe.syntax._
import io.circe.parser._
import Messages._
import Messages.implicits._
import Rows._

object Main extends App
{

  val json = TMMessage(MRequest(UsersRow.toString()), UsersRow(0, "arf@gmail.com", "Arf"))

  println(json.asJson.noSpaces)

  println(decode[TMMessage](json.asJson.noSpaces))

}
