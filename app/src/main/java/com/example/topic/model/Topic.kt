package com.example.topic.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val nameRes: Int, val availableCourses: Int, @DrawableRes val imageResourceId: Int)
