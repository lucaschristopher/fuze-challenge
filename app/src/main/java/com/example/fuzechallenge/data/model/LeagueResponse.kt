package com.example.fuzechallenge.data.model

import com.google.gson.annotations.SerializedName

class LeagueResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("url")
    val url: String?
)
