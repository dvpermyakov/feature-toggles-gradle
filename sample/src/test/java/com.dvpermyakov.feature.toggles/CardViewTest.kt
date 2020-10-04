package com.dvpermyakov.feature.toggles

import com.dvpermyakov.feature.toggles.domain.FeatureToggleRepository
import com.dvpermyakov.feature.toggles.features.card.CardView
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class CardViewTest {

    private val featureToggleRepository = mockk<FeatureToggleRepository> {
        every { isEnabled(any()) } returns true
    }

    private val cardView = CardView(
        featureToggleRepository = featureToggleRepository
    )

    @Test
    fun cardFeatureEnabled() {
        val number = cardView.getNumber()
        Assert.assertEquals(number, 1)
    }

}