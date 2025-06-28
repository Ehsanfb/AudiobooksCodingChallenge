package com.example.audiobookscodingchallenge.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.audiobookscodingchallenge.data.local.FavouritePodcastEntity
import com.example.audiobookscodingchallenge.data.local.PodcastDao
import com.example.audiobookscodingchallenge.data.remote.PodcastApiService
import com.example.audiobookscodingchallenge.data.remote.paging.PodcastPagingSource
import com.example.audiobookscodingchallenge.data.repository.PodcastRepository
import com.example.audiobookscodingchallenge.domain.model.Podcast
import com.example.audiobookscodingchallenge.utils.Constants.PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PodcastRepositoryImpl @Inject constructor(
    private val apiService: PodcastApiService,
    private val dao: PodcastDao
) : PodcastRepository {
    override fun getPodcastsPaged(): Flow<PagingData<Podcast>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { PodcastPagingSource(apiService) }
        ).flow
    }

    override suspend fun toggleFavourite(podcast: Podcast) {
        val entity = FavouritePodcastEntity(
            id = podcast.id,
            title = podcast.title,
            publisher = podcast.publisher,
            thumbnail = podcast.thumbnail,
            description = podcast.description
        )
        val isFavourite = dao.isFavourite(podcast.id).first()
        if (isFavourite) {
            dao.delete(entity)
        } else {
            dao.insert(entity)
        }
    }

    override fun isFavourited(id: String): Flow<Boolean> {
        return dao.isFavourite(id)
    }

    override fun getAllFavourites(): Flow<List<FavouritePodcastEntity>> {
        return dao.getAllFavourites()
    }
}