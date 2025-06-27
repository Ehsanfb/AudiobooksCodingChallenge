package com.example.audiobookscodingchallenge.data.remote.dto

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.audiobookscodingchallenge.domain.model.Podcast

class PodcastPagingSource(
    private val apiService: PodcastApiService
) : PagingSource<Int, Podcast>() {
    override fun getRefreshKey(state: PagingState<Int, Podcast>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Podcast> {
        return try {

            val page = params.key ?: 1
            val response = apiService.getBestPodcasts(page)

            LoadResult.Page(
                data = response.podcasts.map { it.toPodcast() },
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (!response.hasNext) null else page + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}