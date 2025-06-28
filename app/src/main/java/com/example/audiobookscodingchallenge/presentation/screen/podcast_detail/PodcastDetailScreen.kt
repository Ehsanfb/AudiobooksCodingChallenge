package com.example.audiobookscodingchallenge.presentation.screen.podcast_detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.audiobookscodingchallenge.R
import com.example.audiobookscodingchallenge.domain.model.Podcast
import com.example.audiobookscodingchallenge.presentation.ui.theme.ButtonColor
import com.example.audiobookscodingchallenge.utils.Strings


@Composable
fun PodcastDetailScreen(
    navController: NavController,
    viewModel: PodcastDetailViewModel = hiltViewModel()
) {

    val podcast = remember {
        navController.previousBackStackEntry?.savedStateHandle?.get<Podcast>("podcast")
    }

    podcast?.let { viewModel.setPodcast(it) }

    val selectedPodcast by viewModel.podcast.collectAsState()

    selectedPodcast?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.popBackStack() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Back", style = MaterialTheme.typography.bodyMedium)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = it.title,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = it.publisher,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Italic,
                maxLines = 1, overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(24.dp))

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(it.thumbnail)
                    .placeholder(R.drawable.ic_launcher_background)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .size(220.dp)
                    .clip(RoundedCornerShape(14.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
                onClick = {},
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    Strings.FavouriteButtonText,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = it.description,
                style = MaterialTheme.typography.bodyMedium.copy(lineHeight = 20.sp),
                textAlign = TextAlign.Center,
                color = Color.Gray
            )

        }

    }

}