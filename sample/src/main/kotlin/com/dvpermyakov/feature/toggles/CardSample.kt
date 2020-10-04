package com.dvpermyakov.feature.toggles

import com.dvpermyakov.feature.toggles.domain.FeatureToggleId
import com.dvpermyakov.feature.toggles.domain.FeatureToggleRepository

class CardSample(
    private val featureToggleRepository: FeatureToggleRepository
) {

    fun isCardEnabled(): Boolean {
        return featureToggleRepository.isEnabled(FeatureToggleId.CARD)
    }

}