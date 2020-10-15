package com.dvpermyakov.feature.toggles.domain

interface FeatureToggle {
    val id: FeatureToggleId
    val enabled: Boolean
    val name: String
}