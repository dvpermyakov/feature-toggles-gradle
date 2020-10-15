package com.dvpermyakov.feature.toggles.domain

interface FeatureToggleConfig {
    val featureToggles: List<FeatureToggle>
}