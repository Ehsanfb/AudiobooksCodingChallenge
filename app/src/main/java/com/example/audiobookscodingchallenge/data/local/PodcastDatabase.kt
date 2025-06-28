package com.example.audiobookscodingchallenge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavouritePodcastEntity::class], version = 1)
abstract class PodcastDatabase : RoomDatabase() {
    abstract fun podcastDao(): PodcastDao
}