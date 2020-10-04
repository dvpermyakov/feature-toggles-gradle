package com.dvpermyakov.feature.toggles.plugin

import com.dvpermyakov.feature.toggles.task.GenerateFeatureTogglesTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class FeatureTogglePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.tasks.register("toggles", GenerateFeatureTogglesTask::class.java)
    }
}