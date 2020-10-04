package com.dvpermyakov.feature.toggles.task

import com.squareup.kotlinpoet.*
import javax.annotation.processing.Generated

class FeatureToggleObjectCreator(
    private val enabled: Boolean,
    private val name: String
) {
    fun create(): FileSpec {
        return getFileSpec()
    }

    private fun getFileSpec(): FileSpec {
        val fileSpecBuilder = FileSpec.builder("com.dvpermyakov.feature.toggles", "CardFeatureToggle")
        fileSpecBuilder.addType(getTypeSpec())
        return fileSpecBuilder.build()
    }

    private fun getTypeSpec(): TypeSpec {
        val featureToggleType = ClassName("com.dvpermyakov.feature.toggles.domain", "FeatureToggle")
        val objectSpecBuilder = TypeSpec.objectBuilder("CardFeatureToggle")
            .addAnnotation(Generated::class.java)
            .addSuperinterface(featureToggleType)
        objectSpecBuilder.addProperties(listOf(getIdProperty(), getEnabledProperty(), getNameProperty()))
        return objectSpecBuilder.build()
    }

    private fun getIdProperty(): PropertySpec {
        val featureToggleIdType = ClassName("com.dvpermyakov.feature.toggles.domain", "FeatureToggleId")
        return PropertySpec.builder("id", featureToggleIdType, KModifier.OVERRIDE)
            .initializer("FeatureToggleId.CARD")
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