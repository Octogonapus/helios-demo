package com.octogonapus.heliosdemo

import arrow.core.Either
import arrow.core.Try
import arrow.core.flatMap
import helios.core.*
import helios.typeclasses.Decoder
import helios.typeclasses.Encoder

enum class Enum1 {
    A, B;

    companion object
}

fun Enum1.Companion.encoder() = Enum.Companion.encoder<Enum1>()
fun Enum1.Companion.deocder() = Enum.Companion.decoder<Enum1>()

fun <E : Enum<E>> Enum.Companion.encoder(): Encoder<Enum<E>> = object : Encoder<Enum<E>> {
    override fun Enum<E>.encode(): Json = JsString(name)
}

inline fun <reified E : Enum<E>> Enum.Companion.decoder(): Decoder<Enum<E>> =
    object : Decoder<Enum<E>> {

        override fun decode(value: Json): Either<DecodingError, Enum<E>> =
            value.asJsString().toEither { StringDecodingError(value) }.flatMap {
                Try {
                    java.lang.Enum.valueOf(E::class.java, it.value.toString())
                }.toEither { ObjectDecodingError(value) }
            }

    }
