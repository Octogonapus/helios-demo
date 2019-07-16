package com.octogonapus.heliosdemo

import arrow.core.Either
import helios.json

typealias Foo = Either<String, Int>

@json
data class DataClass1(
    val foo: Foo
) {
    companion object
}
