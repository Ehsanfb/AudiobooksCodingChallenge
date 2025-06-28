package com.example.audiobookscodingchallenge.presentation.screen.podcasts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.audiobookscodingchallenge.domain.model.Podcast
import com.example.audiobookscodingchallenge.presentation.components.ErrorItem
import com.example.audiobookscodingchallenge.presentation.components.LoadingItem
import com.example.audiobookscodingchallenge.presentation.components.PodcastItem
import com.example.audiobookscodingchallenge.utils.Strings

@Composable
fun PodcastsScreen(
    viewModel: PodcastsViewModel = hiltViewModel(),
    onItemClick: (Podcast) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = Strings.PodcastsTitle,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(start = 16.dp, top = 32.dp)
        )

        val podcastPagingItems = viewModel.podcastPagingFlow.collectAsLazyPagingItems()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(podcastPagingItems.itemCount) { index ->

                val podcast = podcastPagingItems[index]
                podcast?.let {
                    PodcastItem(podcast = it, onClick = { onItemClick(it) })
                }

            }

            podcastPagingItems.apply {

                when {

                    loadState.refresh is LoadState.Loading -> {
                        item { LoadingItem() }
                    }

                    loadState.refresh is LoadState.Error -> {
                        val errorMessage = (loadState.refresh as LoadState.Error).error.message
                            ?: Strings.ErrorMessage
                        item { ErrorItem(errorMessage) }
                    }

                    loadState.append is LoadState.Loading -> {
                        item { LoadingItem() }
                    }

                    loadState.append is LoadState.Error -> {
                        val errorMessage = (loadState.refresh as LoadState.Error).error.message
                            ?: Strings.ErrorMessage
                        item { ErrorItem(errorMessage) }
                    }

                }

            }

        }

    }

}