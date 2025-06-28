package com.example.audiobookscodingchallenge.data.repository

import androidx.paging.PagingData
import com.example.audiobookscodingchallenge.data.local.FavouritePodcastEntity
import com.example.audiobookscodingchallenge.domain.model.Podcast
import kotlinx.coroutines.flow.Flow

interface PodcastRepository {
    fun getPodcastsPaged(): Flow<PagingData<Podcast>>
    suspend fun toggleFavourite(podcast: Podcast)
    fun isFavourited(id: String): Flow<Boolean>
    fun getAllFavourites(): Flow<List<FavouritePodcastEntity>>
}