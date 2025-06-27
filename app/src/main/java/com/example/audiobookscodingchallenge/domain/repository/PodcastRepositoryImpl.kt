package com.example.audiobookscodingchallenge.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.audiobookscodingchallenge.data.remote.PodcastApiService
import com.example.audiobookscodingchallenge.data.remote.paging.PodcastPagingSource
import com.example.audiobookscodingchallenge.data.repository.PodcastRepository
import com.example.audiobookscodingchallenge.domain.model.Podcast
import com.example.audiobookscodingchallenge.utils.Constants.PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PodcastRepositoryImpl @Inject constructor(
    private val apiService: PodcastApiService
) : PodcastRepository {
    override fun getPodcastsPaged(): Flow<PagingData<Podcast>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { PodcastPagingSource(apiService) }
        ).flow
    }
}