package com.dvpermyakov.feature.toggles.task

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName

object TypeNames {

    fun getFeatureToggle(): TypeName {
        return ClassName(getPackageName(), "FeatureToggle")
    }

    fun getFeatureToggleId(): TypeName {
        return ClassName(getPackageName(), "FeatureToggleId")
    }

    fun getFeatureToggleConfig(): TypeName {
        return ClassName(getPackageName(), "FeatureToggleConfig")
    }

    fun getPackageName() = "com.dvpermyakov.feature.toggles.domain"
}