package com.example.fuzechallenge.data.model

import com.example.fuzechallenge.domain.model.Team
import com.google.gson.annotations.SerializedName

class TeamResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("location") val location: String,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String
)

fun TeamResponse.toDomainModel() = Team(
    id = this.id,
    imageUrl = this.imageUrl,
    location = this.location,
    name = this.name,
    slug = this.slug
)