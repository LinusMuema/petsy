package com.moose.feature_dogs

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class DogsViewModel @ViewModelInject constructor(private val repository: DogsRepository) : ViewModel() {
    val dogs = repository.dog
}