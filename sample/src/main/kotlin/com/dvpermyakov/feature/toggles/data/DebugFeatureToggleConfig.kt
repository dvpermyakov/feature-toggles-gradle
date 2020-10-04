package com.dvpermyakov.feature.toggles.data

import com.dvpermyakov.feature.toggles.domain.FeatureToggle
import com.dvpermyakov.feature.toggles.domain.FeatureToggleConfig

// should be generated
object DebugFeatureToggleConfig : FeatureToggleConfig {
    override val list: List<FeatureToggle> = listOf(CardFeatureToggle)
}