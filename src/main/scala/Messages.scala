/**
  * https://github.com/AdrianRaFo
  */

import Rows._
import Rows.implicits._
import io.circe._
import io.circe.generic.semiauto._

object Messages
{
  sealed trait TMMessageType

  case class MRequest(row : String) extends TMMessageType

  case class MSave(row : String) extends TMMessageType

  case class MResponse(row : String) extends TMMessageType

  case class TMMessage(mType : TMMessageType, data : Row)

  trait Implicits
  {
    implicit val TMMessageDecoder : Decoder[TMMessage] = deriveDecoder[TMMessage]
    implicit val TMMessageEncoder : Encoder[TMMessage] = deriveEncoder[TMMessage]
    implicit val TMMessageTypeDecoder : Decoder[TMMessageType] = deriveDecoder[TMMessageType]
    implicit val TMMessageTypeEncoder : Encoder[TMMessageType] = deriveEncoder[TMMessageType]
  }
  object implicits extends Implicits
}