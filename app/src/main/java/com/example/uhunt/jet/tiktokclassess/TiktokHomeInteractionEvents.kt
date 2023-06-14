package com.example.uhunt.jet.tiktokclassess

import com.example.uhunt.jetpackClassess.model.Album
import com.example.uhunt.models.Featured
import com.example.uhunt.models.ShortsVideoModel

sealed class TiktokHomeInteractionEvents {
    data class OpenProfile(val album: ShortsVideoModel) : TiktokHomeInteractionEvents()
    data class ShareVideo(val album: Album) : TiktokHomeInteractionEvents()
    object OpenComments : TiktokHomeInteractionEvents()
}