package com.example.fuzechallenge.data.model

import com.google.gson.annotations.SerializedName

class GangResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("players")
    val players: List<PlayerResponse>?
)
