package com.octogonapus.heliosdemo

import arrow.optics.Optional
import arrow.optics.Traversal
import helios.core.Json
import helios.optics.select
import helios.optics.extract

/**
  * Select dataClass2 key in [JsObject].
  */
inline val Optional<Json, Json>.dataClass2: Optional<Json, Json>
    inline get() = select("dataClass2")

/**
  * Select dataClass2 key in [JsObject].
  */
inline val arrow.optics.Traversal<Json, Json>.dataClass2: arrow.optics.Traversal<Json, Json>
    inline get() = select("dataClass2")

/**
  * Select enum1 key in [JsObject].
  */
inline val Optional<Json, Json>.enum1: Optional<Json, Json>
    inline get() = select("enum1")

/**
  * Select enum1 key in [JsObject].
  */
inline val arrow.optics.Traversal<Json, Json>.enum1: arrow.optics.Traversal<Json, Json>
    inline get() = select("enum1")

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

/**
  * Extract [DataClass2] from [Json.Companion.path]
  */
fun Optional<Json, Json>.toDataClass2(): Optional<Json, DataClass2>
    = extract(DataClass2.decoder(), DataClass2.encoder())

/**
  * Extract [DataClass2] from [Json.Companion.path]
  */
fun arrow.optics.Traversal<Json, Json>.toDataClass2(): arrow.optics.Traversal<Json, DataClass2>
    = extract(DataClass2.decoder(), DataClass2.encoder())
