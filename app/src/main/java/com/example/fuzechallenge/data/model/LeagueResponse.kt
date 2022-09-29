package com.example.fuzechallenge.data.model

import com.example.fuzechallenge.domain.model.League
import com.google.gson.annotations.SerializedName

class LeagueResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("url") val url: String?
)

fun LeagueResponse.toDomainModel() = League(
    id = this.id,
    imageUrl = this.imageUrl,
    name = this.name,
    slug = this.slug,
    url = this.url
)