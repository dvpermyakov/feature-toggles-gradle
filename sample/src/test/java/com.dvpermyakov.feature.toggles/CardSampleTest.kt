package com.dvpermyakov.feature.toggles

import com.dvpermyakov.feature.toggles.data.FeatureToggleRepositoryImpl
import com.dvpermyakov.feature.toggles.domain.FeatureToggleConfig_custom
import org.junit.Assert
import org.junit.Test

class CardSampleTest {

    private val featureToggleRepository = FeatureToggleRepositoryImpl(
        config = FeatureToggleConfig_custom
    )

    private val cardSample = CardSample(
        featureToggleRepository = featureToggleRepository
    )

    @Test
    fun cardFeatureEnabled() {
        Assert.assertTrue(cardSample.isCardEnabled())
    }

}