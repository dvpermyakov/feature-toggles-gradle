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
}

apply<FeatureTogglePlugin>()