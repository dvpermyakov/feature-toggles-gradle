package com.dvpermyakov.feature.toggles

import org.gradle.api.Plugin
import org.gradle.api.Project

class FeatureTogglePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello") {
            doLast {
                println("Hello from the GreetingPlugin")
            }
        }
    }
}