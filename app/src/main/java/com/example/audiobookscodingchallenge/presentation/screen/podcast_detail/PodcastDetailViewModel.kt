package com.example.audiobookscodingchallenge.presentation.screen.podcast_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.audiobookscodingchallenge.domain.model.Podcast
import com.example.audiobookscodingchallenge.domain.use_case.ToggleFavouriteUseCase
import com.example.audiobookscodingchallenge.utils.Constants
import com.example.audiobookscodingchallenge.utils.Strings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PodcastDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val toggleFavouriteUseCase: ToggleFavouriteUseCase
) : ViewModel() {

    private val podcastId: String =
        checkNotNull(savedStateHandle[Constants.PARAM_PODCAST_ID]) { Strings.nullMovieId }

    private val _podcast = MutableStateFlow<Podcast?>(null)
    val podcast: StateFlow<Podcast?> = _podcast

    fun setPodcast(podcast: Podcast) {
        _podcast.value = podcast
    }

    fun toggleFavourite() {
        _podcast.value?.let {
            viewModelScope.launch {
                toggleFavouriteUseCase(it)
            }
        }
    }

}