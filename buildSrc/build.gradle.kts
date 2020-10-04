plugins {
    kotlin("jvm") version "1.3.72"
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", "1.3.72"))
    implementation(kotlin("gradle-plugin", "1.3.72"))
}