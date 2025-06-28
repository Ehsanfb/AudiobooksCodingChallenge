package com.example.audiobookscodingchallenge.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PodcastDao {

    @Query("SELECT * FROM favourite_podcasts")
    fun getAllFavourites(): Flow<List<FavouritePodcastEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM favourite_podcasts WHERE id = :id)")
    fun isFavourite(id: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(podcast: FavouritePodcastEntity)

    @Delete
    suspend fun delete(podcast: FavouritePodcastEntity)


}