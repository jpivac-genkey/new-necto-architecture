plugins {
    kotlin("jvm") version "1.9.25"
}

group = "com.genkey"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}