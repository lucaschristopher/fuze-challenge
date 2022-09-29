package com.example.fuzechallenge.data.model.detail

import com.example.fuzechallenge.core.constants.EMPTY_STRING
import com.example.fuzechallenge.domain.model.detail.Player
import com.google.gson.annotations.SerializedName

class PlayerResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("first_name") val firstName: String?,
    @SerializedName("last_name") val lastName: String?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("slug") val slug: String?,
)

// Null safety
fun PlayerResponse.toDomainModel() = Player(
    id = this.id,
    firstName = this.firstName ?: EMPTY_STRING,
    lastName = this.lastName ?: EMPTY_STRING,
    imageUrl = this.imageUrl ?: EMPTY_STRING,
    slug = this.slug ?: EMPTY_STRING
)