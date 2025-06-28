package com.example.audiobookscodingchallenge.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_podcasts")
data class FavouritePodcastEntity(
    @PrimaryKey val id: String,
    val title: String,
    val publisher: String,
    val thumbnail: String,
    val description: String
)