package com.dvpermyakov.feature.toggles.task

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName

object TypeNames {

    fun getFeatureToggle(): TypeName {
        return ClassName(getDomainName(), "FeatureToggle")
    }

    fun getFeatureToggleId(): TypeName {
        return ClassName(getDomainName(), "FeatureToggleId")
    }

    fun getFeatureToggleConfig(): TypeName {
        return ClassName(getDomainName(), "FeatureToggleConfig")
    }

    fun getDomainName() = "com.dvpermyakov.feature.toggles.domain"
}