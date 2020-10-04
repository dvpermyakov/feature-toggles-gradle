import com.dvpermyakov.feature.toggles.GreetingPlugin

plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    testImplementation("junit:junit:4.13")
    testImplementation("io.mockk:mockk:1.10.0")
}

apply<GreetingPlugin>()