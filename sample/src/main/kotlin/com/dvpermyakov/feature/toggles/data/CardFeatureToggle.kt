package com.dvpermyakov.feature.toggles.data

import com.dvpermyakov.feature.toggles.domain.FeatureToggle
import com.dvpermyakov.feature.toggles.domain.FeatureToggleId

// should be generated
object CardFeatureToggle : FeatureToggle {
    override val id: FeatureToggleId = FeatureToggleId.CARD
    override val enabled: Boolean = true
    override val name: String = "Card feature"
}