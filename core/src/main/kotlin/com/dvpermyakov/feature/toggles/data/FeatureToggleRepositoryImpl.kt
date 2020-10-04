package com.dvpermyakov.feature.toggles.data

import com.dvpermyakov.feature.toggles.domain.FeatureToggleConfig
import com.dvpermyakov.feature.toggles.domain.FeatureToggleId
import com.dvpermyakov.feature.toggles.domain.FeatureToggleRepository

class FeatureToggleRepositoryImpl(
    private val config: FeatureToggleConfig
) : FeatureToggleRepository {

    override fun isEnabled(toggleId: FeatureToggleId): Boolean {
        return config.list.firstOrNull { it.id == toggleId }?.enabled ?: false
    }

}