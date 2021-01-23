package com.moose.feature_dogs.presentation

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.moose.feature_dogs.DogsRepository
import com.moose.feature_dogs.work.DogsWork

class DogsViewModel @ViewModelInject constructor(repository: DogsRepository) : ViewModel() {
    val dogs = repository.dog

    private val constraints = Constraints.Builder().apply {
        setRequiredNetworkType(NetworkType.CONNECTED)
    }.build()
    private val work = OneTimeWorkRequestBuilder<DogsWork>().setConstraints(constraints).build()

    fun startWork(context: Context){
        WorkManager.getInstance(context).enqueue(work)
    }

}