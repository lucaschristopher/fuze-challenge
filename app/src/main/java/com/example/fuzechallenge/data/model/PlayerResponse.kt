package com.example.fuzechallenge.data.model

import com.google.gson.annotations.SerializedName

class PlayerResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("slug")
    val slug: String?
)
