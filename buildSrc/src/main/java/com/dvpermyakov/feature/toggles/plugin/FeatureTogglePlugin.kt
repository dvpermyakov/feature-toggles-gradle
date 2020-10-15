package com.dvpermyakov.feature.toggles.plugin

import com.dvpermyakov.feature.toggles.domain.FeatureToggle
import com.dvpermyakov.feature.toggles.task.GenerateTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.register
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

open class FeatureTogglePluginExtension {
    lateinit var configName: String
    lateinit var toggles: List<FeatureToggle>
}

class FeatureTogglePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<FeatureTogglePluginExtension>("toggles")
        val task = project.tasks.register<GenerateTask>("toggles") {
            configName = extension.configName
            toggles = extension.toggles
        }
        project.tasks.getByName<KotlinCompile>("compileKotlin").dependsOn(task)
    }
}