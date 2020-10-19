package com.dvpermyakov.feature.toggles.plugin

import com.dvpermyakov.feature.toggles.domain.FeatureToggle

open class FeatureTogglePluginExtension {
    lateinit var configName: String
    lateinit var toggles: List<FeatureToggle>
}