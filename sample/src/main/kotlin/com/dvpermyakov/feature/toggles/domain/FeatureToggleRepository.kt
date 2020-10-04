package com.dvpermyakov.feature.toggles.domain

interface FeatureToggleRepository {
    fun isEnabled(toggleId: FeatureToggleId): Boolean
}