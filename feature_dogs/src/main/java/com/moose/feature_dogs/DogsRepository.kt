package com.moose.feature_dogs

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
    suspend fun getFact(animal: String): Fact
    suspend fun getImage(animal: String): Image
    suspend fun addDog(animal: Animal)
    val dog: Flow<List<Animal>>
}

class DogsRepositoryImpl @Inject constructor(
    private val api: ApiEndpoints,
    private val dao: AppDao
): DogsRepository {

    override suspend fun getFact(animal: String): Fact = api.getFact(animal)

    override suspend fun getImage(animal: String): Image = api.getImage(animal)

    override suspend fun addDog(animal: Animal) = dao.addAnimal(animal)

    override val dog: Flow<List<Animal>> get() = dao.getAnimal("dog")

}

@Module
@InstallIn(ApplicationComponent::class)
abstract class DogsRepositoryModule {

    @Binds
    abstract fun provideRepository(impl: DogsRepositoryImpl): DogsRepository
}