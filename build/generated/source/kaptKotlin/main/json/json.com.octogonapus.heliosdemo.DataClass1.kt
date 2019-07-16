package com.octogonapus.heliosdemo

import arrow.*
import arrow.core.*
import helios.core.*
import helios.instances.*
import helios.typeclasses.*
import helios.syntax.json.*


fun DataClass1.toJson(): Json = JsObject(mapOf(
"foo" to com.octogonapus.heliosdemo.Foo.encoder().run { foo.encode() }
))

fun Json.Companion.toDataClass1(value: Json): Either<DecodingError, DataClass1> =
  
	value["foo"].fold({Either.Left(KeyNotFound("foo"))}, { com.octogonapus.heliosdemo.Foo.decoder().run { decode(it) } })
.map( { foo ->
  DataClass1(foo = foo)
}).fix()



fun DataClass1.Companion.encoder() = object : Encoder<DataClass1> {
  override fun DataClass1.encode(): Json = this.toJson()
}

fun DataClass1.Companion.decoder() = object : Decoder<DataClass1> {
  override fun decode(value: Json): Either<DecodingError, DataClass1> =
    Json.toDataClass1(value)
}

