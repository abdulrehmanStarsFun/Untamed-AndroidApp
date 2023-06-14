package com.example.uhunt.network.dto

data class APINotificationSettings(
    val e_accepted: Int,
    val e_commented: Int,
    val e_followed: Int,
    val e_joined_group: Int,
    val e_liked: Int,
    val e_liked_page: Int,
    val e_memory: Int,
    val e_mentioned: Int,
    val e_profile_wall_post: Int,
    val e_shared: Int,
    val e_visited: Int,
    val e_wondered: Int
)