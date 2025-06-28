package com.example.audiobookscodingchallenge.presentation.screen.podcasts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.audiobookscodingchallenge.data.repository.PodcastRepository
import com.example.audiobookscodingchallenge.domain.use_case.GetPodcastsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PodcastsViewModel @Inject constructor(
    getPodcastsUseCase: GetPodcastsUseCase,
    repository: PodcastRepository
) : ViewModel() {

    val podcastPagingFlow = getPodcastsUseCase().cachedIn(viewModelScope)

    val favourites = repository.getAllFavourites()

}