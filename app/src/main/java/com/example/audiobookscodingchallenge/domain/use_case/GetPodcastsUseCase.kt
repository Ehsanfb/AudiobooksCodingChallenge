package com.example.audiobookscodingchallenge.domain.use_case

import androidx.paging.PagingData
import com.example.audiobookscodingchallenge.data.repository.PodcastRepository
import com.example.audiobookscodingchallenge.domain.model.Podcast
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPodcastsUseCase @Inject constructor(
    private val repository: PodcastRepository
) {

    operator fun invoke(): Flow<PagingData<Podcast>> {
        return repository.getPodcastsPaged()
    }

}