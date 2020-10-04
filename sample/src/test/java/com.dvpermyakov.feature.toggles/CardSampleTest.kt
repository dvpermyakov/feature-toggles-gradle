package com.dvpermyakov.feature.toggles

import com.dvpermyakov.feature.toggles.domain.FeatureToggleRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class CardSampleTest {

    private val featureToggleRepository = mockk<FeatureToggleRepository> {
        every { isEnabled(any()) } returns true
    }

    private val cardSample = CardSample(
        featureToggleRepository = featureToggleRepository
    )

    @Test
    fun cardFeatureEnabled() {
        Assert.assertTrue(cardSample.isCardEnabled())
    }

}