package com.dvpermyakov.feature.toggles.plugin

import com.dvpermyakov.feature.toggles.domain.FeatureToggle
import com.dvpermyakov.feature.toggles.task.GenerateFeatureTogglesTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByName
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

open class FeatureTogglePluginExtension {
    var configName: String = "default"
    var toggles: List<FeatureToggle> = emptyList()
}

class FeatureTogglePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<FeatureTogglePluginExtension>("toggles")
        val task = project.tasks.register("toggles", GenerateFeatureTogglesTask::class.java) {
            configName = extension.configName
            toggles = extension.toggles
        }
        project.tasks.getByName<KotlinCompile>("compileKotlin").dependsOn(task)
    }
}