package com.example.audiobookscodingchallenge.presentation.navigation

sealed class Screen(val route: String) {

    data object Podcasts : Screen("podcasts")
    data object PodcastDetail : Screen("podcast_detail/{podcastId}") {
        fun createRoute(podcastId: String) = "podcast_detail/$podcastId"
    }

}