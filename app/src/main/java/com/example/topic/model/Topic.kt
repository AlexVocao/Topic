package com.example.topic.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val stringResourceId: Int, val numberViews: Int, @DrawableRes val imageResourceId: Int)
