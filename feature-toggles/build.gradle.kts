import com.dvpermyakov.feature.toggles.plugin.FeatureTogglePlugin
import com.dvpermyakov.feature.toggles.plugin.FeatureTogglePluginExtension
import com.dvpermyakov.feature.toggles.domain.FeatureToggle

plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
    mavenCentral()
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
    java.srcDirs("build/generated")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

apply<FeatureTogglePlugin>()
configure<FeatureTogglePluginExtension> {
    configName = "custom"
    toggles = listOf(
        FeatureToggle(
            id = "CARD",
            enabled = true,
            name = "New card enabled"
        ),
        FeatureToggle(
            id = "ACCOUNT",
            enabled = true,
            name = "Account improvement"
        ),
        FeatureToggle(
            id = "MAP",
            enabled = true,
            name = "Map implementation"
        )
    )
}