package com.dvpermyakov.feature.toggles.domain

import java.io.Serializable

data class FeatureToggle(
    val id: String,
    val enabled: Boolean,
    val name: String
) : Serializable