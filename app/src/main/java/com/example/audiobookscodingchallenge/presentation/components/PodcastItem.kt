package com.example.audiobookscodingchallenge.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.audiobookscodingchallenge.R
import com.example.audiobookscodingchallenge.domain.model.Podcast
import com.example.audiobookscodingchallenge.presentation.ui.theme.ButtonColor
import com.example.audiobookscodingchallenge.utils.Strings

@Composable
fun PodcastItem(podcast: Podcast, onClick: () -> Unit, isFavourited: Boolean) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(podcast.thumbnail)
                .placeholder(R.drawable.ic_launcher_background)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(14.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = podcast.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = podcast.publisher,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Italic,
                maxLines = 1, overflow = TextOverflow.Ellipsis
            )

            if (isFavourited) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = Strings.FavouritedButtonText,
                    color = ButtonColor,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun PodcastItemPreview() {

    PodcastItem(
        podcast = Podcast(
            id = "1",
            title = "Podcast1",
            publisher = "Publisher1",
            description = "This is Podcast1",
            thumbnail = "https://cdn-images-3.listennotes.com/podcasts/worklife-with-adam-grant-ted-KgaXjFPEoVc.300x300.jpg"
        ),
        {},
        isFavourited = true
    )

}