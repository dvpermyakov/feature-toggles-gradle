package com.dvpermyakov.feature.toggles.data

import com.dvpermyakov.feature.toggles.domain.FeatureToggle
import com.dvpermyakov.feature.toggles.domain.FeatureToggleConfig
import com.dvpermyakov.feature.toggles.domain.FeatureToggleId
import com.dvpermyakov.feature.toggles.domain.FeatureToggleRepository

class FeatureToggleRepositoryImpl(
    private val config: FeatureToggleConfig
) : FeatureToggleRepository {

    override fun isEnabled(toggleId: FeatureToggleId): Boolean {
        val featureToggle: FeatureToggle? = config.list.firstOrNull { it.id == toggleId }
        return featureToggle?.enabled ?: false
    }

}