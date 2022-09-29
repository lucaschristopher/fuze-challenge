package com.example.fuzechallenge.data.model.detail

import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.domain.model.detail.Gang
import com.google.gson.annotations.SerializedName

class GangResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("players") val players: List<PlayerResponse>?,
)

// Null safety
fun GangResponse.toDomainModel() = Gang(
    id = this.id,
    imageUrl = this.imageUrl ?: EMPTY_STRING,
    name = this.name ?: EMPTY_STRING,
    slug = this.slug ?: EMPTY_STRING,
    players = this.players?.map { it.toDomainModel() } ?: listOf()
)