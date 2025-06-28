package com.example.audiobookscodingchallenge.domain.model

import java.io.Serializable

data class Podcast(
    val id: String,
    val title: String,
    val publisher: String,
    val thumbnail: String,
    val description: String
) : Serializable
