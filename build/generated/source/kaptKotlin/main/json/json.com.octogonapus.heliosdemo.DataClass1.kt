package com.octogonapus.heliosdemo

import arrow.*
import arrow.core.*
import helios.core.*
import helios.instances.*
import helios.typeclasses.*
import helios.syntax.json.*
import arrow.core.extensions.either.applicative.applicative

fun DataClass1.toJson(): Json = JsObject(mapOf(
"dataClass2" to com.octogonapus.heliosdemo.DataClass2.encoder().run { dataClass2.encode() }
,
"enum1" to com.octogonapus.heliosdemo.Enum1.encoder().run { enum1.encode() }
))

fun Json.Companion.toDataClass1(value: Json): Either<DecodingError, DataClass1> =
  Either.applicative<DecodingError>().map(
	value["dataClass2"].fold({Either.Left(KeyNotFound("dataClass2"))}, { com.octogonapus.heliosdemo.DataClass2.decoder().run { decode(it) } }),
	value["enum1"].fold({Either.Left(KeyNotFound("enum1"))}, { com.octogonapus.heliosdemo.Enum1.decoder().run { decode(it) } })
,  { (dataClass2,enum1) ->
  DataClass1(dataClass2 = dataClass2,enum1 = enum1)
}).fix()



fun DataClass1.Companion.encoder() = object : Encoder<DataClass1> {
  override fun DataClass1.encode(): Json = this.toJson()
}

fun DataClass1.Companion.decoder() = object : Decoder<DataClass1> {
  override fun decode(value: Json): Either<DecodingError, DataClass1> =
    Json.toDataClass1(value)
}

