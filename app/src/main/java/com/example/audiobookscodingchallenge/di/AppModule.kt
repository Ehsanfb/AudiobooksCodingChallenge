package com.example.audiobookscodingchallenge.di

import com.example.audiobookscodingchallenge.data.remote.PodcastApiService
import com.example.audiobookscodingchallenge.data.repository.PodcastRepository
import com.example.audiobookscodingchallenge.domain.repository.PodcastRepositoryImpl
import com.example.audiobookscodingchallenge.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePodcastApiService(): PodcastApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PodcastApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: PodcastApiService): PodcastRepository {
        return PodcastRepositoryImpl(apiService)
    }


}