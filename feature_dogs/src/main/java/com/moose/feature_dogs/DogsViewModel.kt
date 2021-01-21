package com.moose.feature_dogs

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DogsViewModel @ViewModelInject constructor(private val repository: DogsRepository) : ViewModel() {

    fun getFact(){
        viewModelScope.launch {
            val fact = repository.getFact("dog")
            Log.d("Petsy", "getFact: $fact")
        }
    }
}