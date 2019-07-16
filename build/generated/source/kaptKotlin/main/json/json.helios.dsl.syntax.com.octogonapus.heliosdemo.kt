package com.octogonapus.heliosdemo

import arrow.optics.Optional
import arrow.optics.Traversal
import helios.core.Json
import helios.optics.select
import helios.optics.extract

/**
  * Select foo key in [JsObject].
  */
inline val Optional<Json, Json>.foo: Optional<Json, Json>
    inline get() = select("foo")

/**
  * Select foo key in [JsObject].
  */
inline val arrow.optics.Traversal<Json, Json>.foo: arrow.optics.Traversal<Json, Json>
    inline get() = select("foo")

/**
  * Extract [DataClass1] from [Json.Companion.path]
  */
fun Optional<Json, Json>.toDataClass1(): Optional<Json, DataClass1>
    = extract(DataClass1.decoder(), DataClass1.encoder())

/**
  * Extract [DataClass1] from [Json.Companion.path]
  */
fun arrow.optics.Traversal<Json, Json>.toDataClass1(): arrow.optics.Traversal<Json, DataClass1>
    = extract(DataClass1.decoder(), DataClass1.encoder())
