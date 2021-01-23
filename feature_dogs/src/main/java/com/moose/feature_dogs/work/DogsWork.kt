package com.moose.feature_dogs.work

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.moose.feature_dogs.Constants.ANIMAL_TYPE
import com.moose.feature_dogs.DogsRepository
import com.moose.feature_dogs.domain.toPresentation
import com.moose.local.Animal
import java.lang.Exception

class DogsWork @WorkerInject constructor(
        @Assisted context: Context,
        @Assisted params: WorkerParameters,
        private val repository: DogsRepository
): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        return try {
            val fact: String = repository.getFact().toPresentation()
            val images: MutableList<String> = ArrayList()

            for (i in 0..9){
                val image = repository.getImage().toPresentation()
                images.add(image)
            }

            val animal = Animal(ANIMAL_TYPE, fact, images)
            repository.addDog(animal)
            Result.success()
        } catch (e: Exception){
            Log.e("Petsy", "doWork: $e")
            Result.failure()
        }
    }
}