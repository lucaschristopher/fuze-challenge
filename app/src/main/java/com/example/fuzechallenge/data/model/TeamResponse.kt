package com.example.fuzechallenge.data.model

import com.google.gson.annotations.SerializedName

class TeamResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)
