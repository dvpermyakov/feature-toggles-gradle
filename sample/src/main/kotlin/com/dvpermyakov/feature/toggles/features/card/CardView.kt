package com.dvpermyakov.feature.toggles.features.card

import com.dvpermyakov.feature.toggles.domain.FeatureToggleId
import com.dvpermyakov.feature.toggles.domain.FeatureToggleRepository

class CardView(
    private val featureToggleRepository: FeatureToggleRepository
) {

    fun getNumber(): Int {
        return if (featureToggleRepository.isEnabled(FeatureToggleId.CARD)) {
            1
        } else {
            0
        }
    }

}