package com.dvpermyakov.feature.toggles.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class GenerateFeatureTogglesTask : DefaultTask() {

    @OutputDirectory
    fun getDestination(): File {
        return project.file("${project.buildDir}/generated")
    }

    @TaskAction
    fun action() {
        val file = getDestination()
        file.parentFile.mkdirs()

        val objCreator = FeatureToggleObjectCreator(
            enabled = true,
            name = "card"
        )
        objCreator.create().writeTo(getDestination())

        val configCreator = FeatureToggleConfigCreator()
        configCreator.create().writeTo(getDestination())

    }
}