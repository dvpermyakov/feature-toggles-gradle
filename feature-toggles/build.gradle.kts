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
            enabled = System.getenv("FT_ACCOUNT")?.toBoolean() ?: false,
            name = "Account improvement"
        ),
        FeatureToggle(
            id = "MAP",
            enabled = File("ft_map.txt").readText().trim().toBoolean(),
            name = "Map implementation"
        )
    )
}