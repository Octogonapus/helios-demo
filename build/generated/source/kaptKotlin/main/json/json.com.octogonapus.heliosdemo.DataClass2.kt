package com.octogonapus.heliosdemo

import arrow.*
import arrow.core.*
import helios.core.*
import helios.instances.*
import helios.typeclasses.*
import helios.syntax.json.*


fun DataClass2.toJson(): Json = JsObject(mapOf(
"foo" to kotlin.Int.encoder().run { foo.encode() }
))

fun Json.Companion.toDataClass2(value: Json): Either<DecodingError, DataClass2> =
  
	value["foo"].fold({Either.Left(KeyNotFound("foo"))}, { kotlin.Int.decoder().run { decode(it) } })
.map( { foo ->
  DataClass2(foo = foo)
}).fix()



fun DataClass2.Companion.encoder() = object : Encoder<DataClass2> {
  override fun DataClass2.encode(): Json = this.toJson()
}

fun DataClass2.Companion.decoder() = object : Decoder<DataClass2> {
  override fun decode(value: Json): Either<DecodingError, DataClass2> =
    Json.toDataClass2(value)
}

