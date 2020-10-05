package com.dvpermyakov.feature.toggles.plugin

import com.dvpermyakov.feature.toggles.domain.FeatureToggle
import com.dvpermyakov.feature.toggles.task.GenerateFeatureTogglesTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

open class FeatureTogglePluginExtension {
    var configName: String = "default"
    var toggles: List<FeatureToggle> = emptyList()
}

class FeatureTogglePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<FeatureTogglePluginExtension>("toggles")
        project.tasks.register("toggles", GenerateFeatureTogglesTask::class.java) {
            configName = extension.configName
            toggles = extension.toggles
        }
    }
}