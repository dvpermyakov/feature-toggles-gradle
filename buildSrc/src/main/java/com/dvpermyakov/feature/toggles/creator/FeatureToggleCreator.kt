package com.dvpermyakov.feature.toggles.creator

import com.dvpermyakov.feature.toggles.task.TypeNames
import com.squareup.kotlinpoet.*
import javax.annotation.processing.Generated
import com.dvpermyakov.feature.toggles.domain.FeatureToggle

class FeatureToggleCreator(
    private val featureToggle: FeatureToggle
) {
    fun createKotlinFile(): FileSpec {
        return getFileSpec()
    }

    fun getFileName() = "FeatureToggle_${featureToggle.id}"

    private fun getFileSpec(): FileSpec {
        return FileSpec.builder(TypeNames.getPackageName(), getFileName())
            .addType(getTypeSpec())
            .build()
    }

    private fun getTypeSpec(): TypeSpec {
        return TypeSpec.objectBuilder(getFileName())
            .addAnnotation(Generated::class.java)
            .addSuperinterface(TypeNames.getFeatureToggle())
            .addProperties(listOf(getIdProperty(), getEnabledProperty(), getNameProperty()))
            .build()
    }

    private fun getIdProperty(): PropertySpec {
        return PropertySpec.builder("id", TypeNames.getFeatureToggleId(), KModifier.OVERRIDE)
            .initializer("FeatureToggleId.${featureToggle.id}")
            .build()
    }

    private fun getEnabledProperty(): PropertySpec {
        return PropertySpec.builder("enabled", Boolean::class, KModifier.OVERRIDE)
            .initializer("${featureToggle.enabled}")
            .build()
    }

    private fun getNameProperty(): PropertySpec {
        return PropertySpec.builder("name", String::class, KModifier.OVERRIDE)
            .initializer("%s", featureToggle.name)
            .build()
    }
}