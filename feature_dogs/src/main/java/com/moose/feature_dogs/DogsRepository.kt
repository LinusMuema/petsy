package com.moose.feature_dogs

import com.moose.remote.ApiEndpoints
import com.moose.remote.Endpoints
import com.moose.remote.Fact
import com.moose.remote.Image
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

interface DogsRepository {
    suspend fun getFact(animal: String): Fact
    suspend fun getImage(animal: String): Image
}

class DogsRepositoryImpl @Inject constructor(@Endpoints private val api: ApiEndpoints): DogsRepository {

    override suspend fun getFact(animal: String): Fact = api.getFact(animal)

    override suspend fun getImage(animal: String): Image = api.getImage(animal)

}

@Module
@InstallIn(ApplicationComponent::class)
abstract class DogsRepositoryModule {

    @Binds
    abstract fun provideRepository(impl: DogsRepositoryImpl): DogsRepository
}