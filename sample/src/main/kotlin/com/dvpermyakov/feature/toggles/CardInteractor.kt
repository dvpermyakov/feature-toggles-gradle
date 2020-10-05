package com.dvpermyakov.feature.toggles

import com.dvpermyakov.feature.toggles.domain.FeatureToggleConfig
import com.dvpermyakov.feature.toggles.domain.FeatureToggleId

class CardInteractor(
    private val config: FeatureToggleConfig
) {
    fun isGooglePayAvailable(): Boolean {
        return config.list.firstOrNull { featureToggle ->
            featureToggle.id == FeatureToggleId.CARD
        }?.enabled ?: false
    }
}
