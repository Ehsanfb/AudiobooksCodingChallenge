package com.example.audiobookscodingchallenge.domain.use_case

import com.example.audiobookscodingchallenge.data.repository.PodcastRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsFavouritedUseCase @Inject constructor(
    private val repository: PodcastRepository
) {
    operator fun invoke(id: String): Flow<Boolean> = repository.isFavourited(id)
}