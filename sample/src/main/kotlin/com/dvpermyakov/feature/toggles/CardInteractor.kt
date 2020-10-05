package com.dvpermyakov.feature.toggles

import com.dvpermyakov.feature.toggles.domain.FeatureToggleId
import com.dvpermyakov.feature.toggles.domain.FeatureToggleRepository

class CardInteractor(
    private val featureToggleRepository: FeatureToggleRepository
) {

    fun isGooglePayEnabled(): Boolean {
        return featureToggleRepository.isEnabled(FeatureToggleId.CARD)
    }
}