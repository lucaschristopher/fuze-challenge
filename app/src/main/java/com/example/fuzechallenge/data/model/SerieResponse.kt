package com.example.fuzechallenge.data.model

import com.google.gson.annotations.SerializedName

internal class SerieResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("slug")
    val slug: String?
)
