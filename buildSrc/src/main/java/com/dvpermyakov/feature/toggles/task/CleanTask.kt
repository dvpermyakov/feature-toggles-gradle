package com.dvpermyakov.feature.toggles.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class CleanTask : DefaultTask() {

    @TaskAction
    fun action() {
        val directory = File("${project.buildDir}/generated")
        directory.deleteRecursively()
    }
}