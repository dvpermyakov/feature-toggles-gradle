package com.dvpermyakov.feature.toggles.task

import com.dvpermyakov.feature.toggles.creator.FeatureToggleConfigCreator
import com.dvpermyakov.feature.toggles.creator.FeatureToggleObjectCreator
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
        val objCreators = toggles.map { toggle ->
            FeatureToggleObjectCreator(toggle)
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