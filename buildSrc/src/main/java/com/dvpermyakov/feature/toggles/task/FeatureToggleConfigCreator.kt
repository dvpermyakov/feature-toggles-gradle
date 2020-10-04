package com.dvpermyakov.feature.toggles.task

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import javax.annotation.processing.Generated

class FeatureToggleConfigCreator {
    fun create(): FileSpec {
        return getFileSpec()
    }

    private fun getFileSpec(): FileSpec {
        val fileSpecBuilder = FileSpec.builder("com.dvpermyakov.feature.toggles", "FeatureToggleConfig")
        fileSpecBuilder.addType(getTypeSpec())
        return fileSpecBuilder.build()
    }

    private fun getTypeSpec(): TypeSpec {
        val featureToggleType = ClassName("com.dvpermyakov.feature.toggles.domain", "FeatureToggleConfig")
        val objectSpecBuilder = TypeSpec.objectBuilder("DebugFeatureToggleConfig")
            .addAnnotation(Generated::class.java)
            .addSuperinterface(featureToggleType)
        objectSpecBuilder.addProperties(listOf(getListProperty()))
        return objectSpecBuilder.build()
    }

    private fun getListProperty(): PropertySpec {
        val featureToggleType = ClassName("com.dvpermyakov.feature.toggles.domain", "FeatureToggle")
        val listType = ClassName("kotlin.collections", "List").parameterizedBy(featureToggleType)
        return PropertySpec.builder("list", listType, KModifier.OVERRIDE)
            .initializer("listOf()")
            .build()
    }
}