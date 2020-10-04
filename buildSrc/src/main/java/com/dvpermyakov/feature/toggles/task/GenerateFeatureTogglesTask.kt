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

        val list = listOf(
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
                name = "Account improvement"
            )
        )
        val objCreators = list.map { toggle ->
            FeatureToggleObjectCreator(
                id = toggle.id,
                enabled = toggle.enabled,
                name = toggle.name
            )
        }
        objCreators.forEach { creator ->
            creator.create().writeTo(getDestination())
        }

        val configCreator = FeatureToggleConfigCreator(
            id = "default",
            list = objCreators.map { creator -> creator.getFileName() }
        )
        configCreator.create().writeTo(getDestination())

    }

    private data class FeatureToggle(
        val id: String,
        val enabled: Boolean,
        val name: String
    )
}