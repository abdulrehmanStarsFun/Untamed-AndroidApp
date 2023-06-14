package com.example.uhunt.models

data class GetWatchingVideoModel(
    val `1080p`: Int,
    val `2048p`: Int,
    val `240p`: Int,
    val `360p`: Int,
    val `4096p`: Int,
    val `480p`: Int,
    val `720p`: Int,
    val active: Int,
    val age_restriction: Int,
    val agora_resource_id: Any,
    val agora_sid: String,
    val agora_token: Any,
    val ajax_url: String,
    val approved: Int,
    val aws_guid: String,
    val category_id: String,
    val category_name: String,
    val channel_id: Int,
    val converted: Int,
    val country: String,
    val daily: String,
    val dash_url: String,
    val demo: String,
    val description: String,
    val duration: String,
    val edit_description: String,
    val embedding: Int,
    val facebook: String,
    val featured: Int,
    val file_name: String,
    val geo_blocking: String,
    val gif: String,
    val hls_url: String,
    val id: Int,
    val is_disliked: Int,
    val is_liked: Int,
    val is_movie: Int,
    val is_owner: Boolean,
    val is_purchased: Int,
    val is_short: Int,
    val is_stock: Int,
    val license: String,
    val live_chating: String,
    val live_ended: Int,
    val live_time: Int,
    val markup_description: String,
    val monetization: Int,
    val movie_release: String,
    val mp4Outputs: String,
    val ok: String,
    val org_thumbnail: String,
    val owner: OwnerXXX,
    val paused_time: PausedTime,
    val privacy: Int,
    val producer: String,
    val publication_date: Int,
    val quality: String,
    val rating: String,
    val registered: String,
    val rent_price: Int,
    val se_video_id: Int,
    val sell_video: Int,
    val short_id: String,
    val size: Int,
    val source: String,
    val stars: String,
    val status: Int,
    val stream_name: String,
    val sub_category: String,
    val tags: String,
    val thumbnail: String,
    val time: Int,
    val time_ago: String,
    val time_alpha: String,
    val time_date: String,
    val title: String,
    val trailer: String,
    val twitch: String,
    val twitch_type: String,
    val type: String,
    val url: String,
    val user_id: Int,
    val video_id: String,
    val video_id_: String,
    val video_location: String,
    val video_type: String,
    val views: Int,
    val vimeo: String,
    val youtube: String
)