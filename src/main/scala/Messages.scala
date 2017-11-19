/**
  * https://github.com/AdrianRaFo
  */

import io.circe._
import io.circe.generic.semiauto._
object Messages{

sealed trait Row

  case class UsersRow(iduser : Int, email : String, name : String, var coins : Int = 0, login : Boolean = false)
      extends Row


 sealed trait TMMessageType

 case class MRequest(row : String) extends TMMessageType

   case class MSave(row : String) extends TMMessageType

   case class MResponse(row : String) extends TMMessageType


   case class TMMessage(mType : TMMessageType, data : Row)
trait Implicits
{
  implicit val decodeRow : Decoder[Row] = deriveDecoder[Row]
  implicit val decodeTMMessageType : Decoder[TMMessageType] = deriveDecoder[TMMessageType]
  implicit val decodeTMMessage : Decoder[TMMessage] = deriveDecoder[TMMessage]


  implicit val encodeRow : Encoder[Row] = deriveEncoder[Row]
  implicit val encodeTMMessageType : Encoder[TMMessageType] = deriveEncoder[TMMessageType]
  implicit val encodeTMMessage : Encoder[TMMessage] = deriveEncoder[TMMessage]
}
object implicits extends Implicits

}