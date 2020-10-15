plugins {
    kotlin("jvm") version "1.3.70"
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", "1.3.70"))
    implementation(kotlin("gradle-plugin", "1.3.70"))
    implementation("com.squareup:kotlinpoet:1.6.0")
}