package com.moose.feature_dogs.domain

import com.moose.local.Animal
import com.moose.remote.Fact
import com.moose.remote.Image
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

fun Fact.toPresentation() = this.fact

fun Image.toPresentation() = this.link