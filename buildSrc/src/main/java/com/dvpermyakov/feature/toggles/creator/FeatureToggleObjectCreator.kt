package com.dvpermyakov.feature.toggles.creator

import com.dvpermyakov.feature.toggles.task.TypeNames
import com.squareup.kotlinpoet.*
import javax.annotation.processing.Generated

class FeatureToggleObjectCreator(
    private val id: String,
    private val enabled: Boolean,
    private val name: String
) {
    fun create(): FileSpec {
        return getFileSpec()
    }

    fun getFileName() = "FeatureToggle_${id}"

    private fun getFileSpec(): FileSpec {
        val fileSpecBuilder = FileSpec.builder(TypeNames.getDomainName(), getFileName())
        fileSpecBuilder.addType(getTypeSpec())
        return fileSpecBuilder.build()
    }

    private fun getTypeSpec(): TypeSpec {
        val objectSpecBuilder = TypeSpec.objectBuilder(getFileName())
            .addAnnotation(Generated::class.java)
            .addSuperinterface(TypeNames.getFeatureToggle())
        objectSpecBuilder.addProperties(listOf(getIdProperty(), getEnabledProperty(), getNameProperty()))
        return objectSpecBuilder.build()
    }

    private fun getIdProperty(): PropertySpec {
        return PropertySpec.builder("id", TypeNames.getFeatureToggleId(), KModifier.OVERRIDE)
            .initializer("FeatureToggleId.$id")
            .build()
    }

    private fun getEnabledProperty(): PropertySpec {
        return PropertySpec.builder("enabled", Boolean::class, KModifier.OVERRIDE)
            .initializer("$enabled")
            .build()
    }

    private fun getNameProperty(): PropertySpec {
        return PropertySpec.builder("name", String::class, KModifier.OVERRIDE)
            .initializer("\"$name\"")
            .build()
    }
}