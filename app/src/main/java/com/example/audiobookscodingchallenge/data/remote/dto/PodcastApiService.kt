package com.example.audiobookscodingchallenge.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Query

interface PodcastApiService {

    @GET("best_podcasts")
    suspend fun getBestPodcasts(
        @Query("page") page: Int = 1,
        @Query("sort") sort: String = "listen_score",
        @Query("safe_mode") safeMode: Int = 0
    ): PodcastDto

}