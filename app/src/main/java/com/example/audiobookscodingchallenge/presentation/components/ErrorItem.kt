package com.example.audiobookscodingchallenge.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.audiobookscodingchallenge.presentation.ui.theme.ErrorColor

@Composable
fun ErrorItem(message: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), contentAlignment = Alignment.Center
    )
    {
        Text(
            text = message,
            color = ErrorColor,
            modifier = Modifier.padding(16.dp)
        )
    }

}