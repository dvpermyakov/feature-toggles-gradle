package com.dvpermyakov.feature.toggles.creator

import com.dvpermyakov.feature.toggles.task.TypeNames
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
        return FileSpec.builder(TypeNames.getPackageName(), getFileName())
            .addType(getTypeSpec())
            .build()
    }

    private fun getTypeSpec(): TypeSpec {
        return TypeSpec.objectBuilder(getFileName())
            .addAnnotation(Generated::class.java)
            .addSuperinterface(TypeNames.getFeatureToggleConfig())
            .addProperties(listOf(getListProperty()))
            .build()
    }

    private fun getListProperty(): PropertySpec {
        val listType = ClassName("kotlin.collections", "List")
            .parameterizedBy(TypeNames.getFeatureToggle())
        return PropertySpec.builder("list", listType, KModifier.OVERRIDE)
            .initializer("listOf(${list.joinToString(", ")})")
            .build()
    }
}