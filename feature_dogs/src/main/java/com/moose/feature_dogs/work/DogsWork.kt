package com.moose.feature_dogs.work

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.moose.feature_dogs.Constants.ANIMAL_TYPE
import com.moose.feature_dogs.DogsRepository
import com.moose.feature_dogs.domain.toPresentation
import com.moose.local.Animal
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.lang.Exception

class DogsWork @WorkerInject constructor(
        @Assisted context: Context,
        @Assisted params: WorkerParameters,
        private val repository: DogsRepository
): CoroutineWorker(context, params) {


    private val images = mutableSetOf<String>()

    override suspend fun doWork(): Result {

        return try {
            val fact: String = repository.getFact().toPresentation()
            (0..9).map { getImages() }.joinAll()

            val animal = Animal(ANIMAL_TYPE, fact, images.toList())
            repository.addDog(animal)

            Result.success()
        } catch (e: Exception){ Result.failure() }
    }

    private suspend fun getImages(): Job {
        return GlobalScope.launch {
            val image = repository.getImage().toPresentation()
            images.add(image)
        }
    }
}