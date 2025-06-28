package com.example.audiobookscodingchallenge.domain.use_case

import com.example.audiobookscodingchallenge.data.repository.PodcastRepository
import com.example.audiobookscodingchallenge.domain.model.Podcast
import javax.inject.Inject

class ToggleFavouriteUseCase @Inject constructor(
    private val repository: PodcastRepository
) {

    suspend operator fun invoke(podcast: Podcast) = repository.toggleFavourite(podcast)

}