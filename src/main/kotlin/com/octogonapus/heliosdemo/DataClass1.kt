package com.octogonapus.heliosdemo

import helios.json

@json
data class DataClass1(
    val enum1: Enum1,
    val dataClass2: DataClass2
) {
    companion object
}
