package com.example.fuzechallenge.data.model

import com.example.fuzechallenge.domain.model.Serie
import com.google.gson.annotations.SerializedName

class SerieResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("slug") val slug: String?,
)

fun SerieResponse.toDomainModel() = Serie(
    id = this.id,
    name = this.name,
    description = this.description,
    slug = this.slug
)