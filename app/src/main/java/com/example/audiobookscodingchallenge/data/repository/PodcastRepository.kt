package com.example.audiobookscodingchallenge.data.repository

import androidx.paging.PagingData
import com.example.audiobookscodingchallenge.domain.model.Podcast
import kotlinx.coroutines.flow.Flow

interface PodcastRepository {
    fun getPodcastsPaged(): Flow<PagingData<Podcast>>
}