import cats.syntax.either._
import io.circe._
import io.circe.generic.semiauto._

object Rows {

  sealed trait Row

  case class BossesRow(idbosses: Int, life: Int, size: Int, coins: Int, defense: Int) extends Row

  case class BullletsRow(idbulllet: Int, iditem: Int, form: String = "cir", size: Int, hit: Int) extends Row

  case class CannonsRow(
      idcannon: Int,
      iditem: Int,
      name: String = "default",
      level: Int,
      charge: Int,
      size: Int,
      speed: Int)
      extends Row

  case class EventsRow(idevent: Int, name: String, `type`: String, begin: java.sql.Date, until: java.sql.Date)
      extends Row

  case class ItemsRow(iditem: Int, name: String, `type`: String, price: Int, description: String) extends Row

  case class KeyRow(iduser: Int, restore: String) extends Row

  case class PlayedEventsRow(iduser: Int, idevent: Int, played: java.sql.Date) extends Row

  case class PurchasesRow(idpurchases: Int, date: java.sql.Timestamp, iduser: Int, iditem: Int) extends Row

  case class RecordsRow(idrecord: Int, iduser: Int, monthly: Int = 0, score: Int, date: java.sql.Timestamp) extends Row

  case class ShieldsRow(idshieldstat: Int, iditem: Int, name: String = "black", level: Int, respawn: Int, standup: Int)
      extends Row

  case class UsersRow(iduser: Int, email: String, name: String, var coins: Int = 0, login: Boolean = false) extends Row

  case class UsersItemsRow(iditem: Int, iduser: Int, amount: Int, level: Option[Int] = None, color: Option[Int] = None)
      extends Row

  trait Implicits {
    implicit val RowDecoder: Decoder[Row] = deriveDecoder[Row]
    implicit val RowEncoder: Encoder[Row] = deriveEncoder[Row]

    implicit val DateEncoder: Encoder[java.sql.Date] = Encoder.encodeString.contramap[java.sql.Date](_.toString)

    implicit val DateDecoder: Decoder[java.sql.Date] = Decoder.decodeString.emap { str =>
      Either.catchNonFatal(java.sql.Date.valueOf(str)).leftMap(t => "Date")
    }
    implicit val TimestampEncoder: Encoder[java.sql.Timestamp] =
      Encoder.encodeString.contramap[java.sql.Timestamp](_.toString)

    implicit val TimestampDecoder: Decoder[java.sql.Timestamp] = Decoder.decodeString.emap { str =>
      Either.catchNonFatal(java.sql.Timestamp.valueOf(str)).leftMap(t => "Timestamp")
    }

    implicit val BossesRowDecoder: Decoder[BossesRow] = deriveDecoder[BossesRow]
    implicit val BossesRowEncoder: Encoder[BossesRow] = deriveEncoder[BossesRow]

    implicit val BullletsRowDecoder: Decoder[BullletsRow] = deriveDecoder[BullletsRow]
    implicit val BullletsRowEncoder: Encoder[BullletsRow] = deriveEncoder[BullletsRow]

    implicit val CannonsRowDecoder: Decoder[CannonsRow] = deriveDecoder[CannonsRow]
    implicit val CannonsRowEncoder: Encoder[CannonsRow] = deriveEncoder[CannonsRow]

    implicit val EventsRowDecoder: Decoder[EventsRow] = deriveDecoder[EventsRow]
    implicit val EventsRowEncoder: Encoder[EventsRow] = deriveEncoder[EventsRow]

    implicit val ItemsRowDecoder: Decoder[ItemsRow] = deriveDecoder[ItemsRow]
    implicit val ItemsRowEncoder: Encoder[ItemsRow] = deriveEncoder[ItemsRow]

    implicit val KeyRowDecoder: Decoder[KeyRow] = deriveDecoder[KeyRow]
    implicit val KeyRowEncoder: Encoder[KeyRow] = deriveEncoder[KeyRow]

    implicit val PlayedEventsRowDecoder: Decoder[PlayedEventsRow] = deriveDecoder[PlayedEventsRow]
    implicit val PlayedEventsRowEncoder: Encoder[PlayedEventsRow] = deriveEncoder[PlayedEventsRow]

    implicit val PurchasesRowDecoder: Decoder[PurchasesRow] = deriveDecoder[PurchasesRow]
    implicit val PurchasesRowEncoder: Encoder[PurchasesRow] = deriveEncoder[PurchasesRow]

    implicit val RecordsRowDecoder: Decoder[RecordsRow] = deriveDecoder[RecordsRow]
    implicit val RecordsRowEncoder: Encoder[RecordsRow] = deriveEncoder[RecordsRow]

    implicit val ShieldsRowDecoder: Decoder[ShieldsRow] = deriveDecoder[ShieldsRow]
    implicit val ShieldsRowEncoder: Encoder[ShieldsRow] = deriveEncoder[ShieldsRow]

    implicit val UsersRowDecoder: Decoder[UsersRow] = deriveDecoder[UsersRow]
    implicit val UsersRowEncoder: Encoder[UsersRow] = deriveEncoder[UsersRow]

    implicit val UsersItemsRowDecoder: Decoder[UsersItemsRow] = deriveDecoder[UsersItemsRow]
    implicit val UsersItemsRowEncoder: Encoder[UsersItemsRow] = deriveEncoder[UsersItemsRow]

  }

  object implicits extends Implicits

}
