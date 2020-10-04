package com.dvpermyakov.feature.toggles.domain

interface FeatureToggleConfig {
    val list: List<FeatureToggle>
}