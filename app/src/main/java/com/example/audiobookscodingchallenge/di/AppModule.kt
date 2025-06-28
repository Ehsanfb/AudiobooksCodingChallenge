package com.example.audiobookscodingchallenge.di

import android.content.Context
import androidx.room.Room
import com.example.audiobookscodingchallenge.data.local.PodcastDao
import com.example.audiobookscodingchallenge.data.local.PodcastDatabase
import com.example.audiobookscodingchallenge.data.remote.PodcastApiService
import com.example.audiobookscodingchallenge.data.repository.PodcastRepository
import com.example.audiobookscodingchallenge.domain.repository.PodcastRepositoryImpl
import com.example.audiobookscodingchallenge.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @Singleton
    fun provideRepository(apiService: PodcastApiService, dao: PodcastDao): PodcastRepository {
        return PodcastRepositoryImpl(apiService, dao)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PodcastDatabase {
        return Room.databaseBuilder(
            context,
            PodcastDatabase::class.java,
            "podcast_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: PodcastDatabase): PodcastDao = db.podcastDao()


}