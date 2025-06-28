package com.example.audiobookscodingchallenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.audiobookscodingchallenge.presentation.navigation.Screen
import com.example.audiobookscodingchallenge.presentation.screen.podcast_detail.PodcastDetailScreen
import com.example.audiobookscodingchallenge.presentation.screen.podcasts.PodcastsScreen
import com.example.audiobookscodingchallenge.presentation.ui.theme.AudiobooksCodingChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AudiobooksCodingChallengeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Podcasts.route
                    ) {

                        composable(Screen.Podcasts.route) {
                            PodcastsScreen(
                                onItemClick = { podcast ->

                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                        "podcast",
                                        podcast
                                    )

                                    navController.navigate(Screen.PodcastDetail.route)

                                })
                        }

                        composable(Screen.PodcastDetail.route) {
                            PodcastDetailScreen(navController)
                        }

                    }

                }
            }
        }
    }
}
