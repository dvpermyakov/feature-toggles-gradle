package com.dvpermyakov.feature.toggles.task

import com.dvpermyakov.feature.toggles.creator.FeatureToggleConfigCreator
import com.dvpermyakov.feature.toggles.creator.FeatureToggleCreator
import com.dvpermyakov.feature.toggles.domain.FeatureToggle
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class GenerateTask : DefaultTask() {

    @Input
    lateinit var configName: String

    @Input
    lateinit var toggles: List<FeatureToggle>

    @OutputDirectory
    val generatedDirectory: File = project.file("${project.buildDir}/generated")

    @TaskAction
    fun action() {
        val toggleCreators = toggles.map { toggle ->
            FeatureToggleCreator(toggle)
        }
        toggleCreators.forEach { creator ->
            creator.createFileSpec().writeTo(generatedDirectory)
        }

        val configCreator = FeatureToggleConfigCreator(
            name = configName,
            list = toggleCreators.map { creator -> creator.getFileName() }
        )
        configCreator.createFileSpec().writeTo(generatedDirectory)
    }
}