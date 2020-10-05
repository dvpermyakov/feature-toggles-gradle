package com.dvpermyakov.feature.toggles

import com.dvpermyakov.feature.toggles.domain.FeatureToggleConfig_custom
import org.junit.Assert
import org.junit.Test

class CardInteractorTest {

    private val cardInteractor = CardInteractor(
        config = FeatureToggleConfig_custom
    )

    @Test
    fun cardFeatureEnabled() {
        Assert.assertTrue(cardInteractor.isGooglePayAvailable())
    }

}