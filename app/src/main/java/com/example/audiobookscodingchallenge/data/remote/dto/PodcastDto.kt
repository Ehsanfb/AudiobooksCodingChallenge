package com.example.audiobookscodingchallenge.data.remote.dto


import com.example.audiobookscodingchallenge.domain.model.Podcast
import com.google.gson.annotations.SerializedName

data class PodcastDto(
    @SerializedName("has_next")
    val hasNext: Boolean,
    @SerializedName("has_previous")
    val hasPrevious: Boolean,
    val id: Int,
    @SerializedName("listennotes_url")
    val listennotesUrl: String,
    val name: String,
    @SerializedName("next_page_number")
    val nextPageNumber: Int,
    @SerializedName("page_number")
    val pageNumber: Int,
    @SerializedName("parent_id")
    val parentId: Int,
    val podcasts: List<PodcastModel>,
    @SerializedName("previous_page_number")
    val previousPageNumber: Int,
    val total: Int
) {
    data class PodcastModel(
        @SerializedName("audio_length_sec")
        val audioLengthSec: Int,
        val country: String,
        val description: String,
        @SerializedName("earliest_pub_date_ms")
        val earliestPubDateMs: Long,
        val email: String,
        @SerializedName("explicit_content")
        val explicitContent: Boolean,
        val extra: Extra,
        @SerializedName("genre_ids")
        val genreIds: List<Int>,
        @SerializedName("has_guest_interviews")
        val hasGuestInterviews: Boolean,
        @SerializedName("has_sponsors")
        val hasSponsors: Boolean,
        val id: String,
        val image: String,
        @SerializedName("is_claimed")
        val isClaimed: Boolean,
        @SerializedName("itunes_id")
        val itunesId: Int,
        val language: String,
        @SerializedName("latest_episode_id")
        val latestEpisodeId: String,
        @SerializedName("latest_pub_date_ms")
        val latestPubDateMs: Long,
        @SerializedName("listen_score")
        val listenScore: Int,
        @SerializedName("listen_score_global_rank")
        val listenScoreGlobalRank: String,
        @SerializedName("listennotes_url")
        val listennotesUrl: String,
        @SerializedName("looking_for")
        val lookingFor: LookingFor,
        val publisher: String,
        val rss: String,
        val thumbnail: String,
        val title: String,
        @SerializedName("total_episodes")
        val totalEpisodes: Int,
        val type: String,
        @SerializedName("update_frequency_hours")
        val updateFrequencyHours: Int,
        val website: String
    ) {
        data class Extra(
            @SerializedName("amazon_music_url")
            val amazonMusicUrl: String,
            @SerializedName("facebook_handle")
            val facebookHandle: String,
            @SerializedName("instagram_handle")
            val instagramHandle: String,
            @SerializedName("linkedin_url")
            val linkedinUrl: String,
            @SerializedName("patreon_handle")
            val patreonHandle: String,
            @SerializedName("spotify_url")
            val spotifyUrl: String,
            @SerializedName("twitter_handle")
            val twitterHandle: String,
            val url1: String,
            val url2: String,
            val url3: String,
            @SerializedName("wechat_handle")
            val wechatHandle: String,
            @SerializedName("youtube_url")
            val youtubeUrl: String
        )

        data class LookingFor(
            val cohosts: Boolean,
            @SerializedName("cross_promotion")
            val crossPromotion: Boolean,
            val guests: Boolean,
            val sponsors: Boolean
        )

        fun toPodcast(): Podcast {
            return Podcast(
                id = id,
                title = title,
                publisher = publisher,
                thumbnail = thumbnail,
                description = description
            )
        }
    }
}