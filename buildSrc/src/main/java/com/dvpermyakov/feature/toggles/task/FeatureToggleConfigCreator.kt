package com.dvpermyakov.feature.toggles.task

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import javax.annotation.processing.Generated

class FeatureToggleConfigCreator(
    private val id: String,
    private val list: List<String>
) {
    fun create(): FileSpec {
        return getFileSpec()
    }

    private fun getFileName() = "FeatureToggleConfig_${id}"

    private fun getFileSpec(): FileSpec {
        val fileSpecBuilder = FileSpec.builder(TypeNames.getDomainName(), getFileName())
        fileSpecBuilder.addType(getTypeSpec())
        return fileSpecBuilder.build()
    }

    private fun getTypeSpec(): TypeSpec {
        val featureToggleType = TypeNames.getFeatureToggleConfig()
        val objectSpecBuilder = TypeSpec.objectBuilder(getFileName())
            .addAnnotation(Generated::class.java)
            .addSuperinterface(featureToggleType)
        objectSpecBuilder.addProperties(listOf(getListProperty()))
        return objectSpecBuilder.build()
    }

    private fun getListProperty(): PropertySpec {
        val listType = ClassName("kotlin.collections", "List")
            .parameterizedBy(TypeNames.getFeatureToggle())
        return PropertySpec.builder("list", listType, KModifier.OVERRIDE)
            .initializer("listOf(${list.joinToString(", ")})")
            .build()
    }
}