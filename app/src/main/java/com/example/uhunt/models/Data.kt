package com.example.uhunt.models

data class Data(
    val fav: List<Any>,
    val featured: List<Featured>,
    val latest: List<Latest>,
    val live: List<Any>,
    val top: List<Top>
)