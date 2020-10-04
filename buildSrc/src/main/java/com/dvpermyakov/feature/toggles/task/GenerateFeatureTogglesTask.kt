package com.dvpermyakov.feature.toggles.task

import com.dvpermyakov.feature.toggles.domain.FeatureToggle
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class GenerateFeatureTogglesTask : DefaultTask() {

    @Input
    var configName: String = "default"

    @Input
    var toggles: List<FeatureToggle> = emptyList()

    @OutputDirectory
    fun getDestination(): File {
        return project.file("${project.buildDir}/generated")
    }

    @TaskAction
    fun action() {
        val file = getDestination()
        file.parentFile.mkdirs()

        val objCreators = toggles.map { toggle ->
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
            id = configName,
            list = objCreators.map { creator -> creator.getFileName() }
        )
        configCreator.create().writeTo(getDestination())

    }
}