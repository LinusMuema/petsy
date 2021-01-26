package com.moose.petsy.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.core.graphics.drawable.DrawableCompat

fun String.format() = this.replace("_", " ").capitalize()