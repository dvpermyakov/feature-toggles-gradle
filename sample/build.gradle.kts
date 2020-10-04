import com.dvpermyakov.feature.toggles.plugin.FeatureTogglePlugin

plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
    java.srcDirs("build/generated")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation(project(":core"))

    testImplementation("junit:junit:4.13")
    testImplementation("io.mockk:mockk:1.10.0")
}

apply<FeatureTogglePlugin>()