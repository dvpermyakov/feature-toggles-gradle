plugins {
    kotlin("jvm") version "1.4.10"
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", "1.4.10"))
    implementation(kotlin("gradle-plugin", "1.4.10"))
    implementation("com.squareup:kotlinpoet:1.6.0")
}