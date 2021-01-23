package com.moose.feature_dogs.domain

import com.moose.remote.Fact
import com.moose.remote.Image

fun Fact.toPresentation() = this.fact

fun Image.toPresentation() = this.link