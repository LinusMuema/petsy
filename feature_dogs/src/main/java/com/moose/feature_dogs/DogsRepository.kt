package com.moose.feature_dogs

import com.moose.feature_dogs.Constants.ANIMAL_TYPE
import com.moose.local.Animal
import com.moose.local.AppDao
import com.moose.remote.ApiEndpoints
import com.moose.remote.Fact
import com.moose.remote.Image
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface DogsRepository {
    suspend fun getFact(): Fact
    suspend fun getImage(): Image
    suspend fun addDog(animal: Animal)
    val dog: Flow<List<Animal>>
}

class DogsRepositoryImpl @Inject constructor(
    private val api: ApiEndpoints,
    private val dao: AppDao
): DogsRepository {

    override suspend fun getFact(): Fact = api.getFact(ANIMAL_TYPE)

    override suspend fun getImage(): Image = api.getImage(ANIMAL_TYPE)

    override suspend fun addDog(animal: Animal) = dao.addAnimal(animal)

    override val dog: Flow<List<Animal>> get() = dao.getAnimal("dog")

}

@Module
@InstallIn(ApplicationComponent::class)
abstract class DogsRepositoryModule {

    @Binds
    abstract fun provideRepository(impl: DogsRepositoryImpl): DogsRepository
}