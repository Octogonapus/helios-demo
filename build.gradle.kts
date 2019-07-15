import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
    kotlin("kapt") version "1.3.41"
}

apply {
    from(rootProject.file("gradle/generated-kotlin-sources.gradle"))
}

group = "com.octogonapus"
version = "0.1.0"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/47deg/helios")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation(
        group = "com.47deg",
        name = "helios-core",
        version = property("helios.version") as String
    )
    implementation(
        group = "com.47deg",
        name = "helios-parser",
        version = property("helios.version") as String
    )
    implementation(
        group = "com.47deg",
        name = "helios-optics",
        version = property("helios.version") as String
    )
    kapt(
        group = "com.47deg",
        name = "helios-meta",
        version = property("helios.version") as String
    )
    kapt(
        group = "com.47deg",
        name = "helios-dsl-meta",
        version = property("helios.version") as String
    )
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
