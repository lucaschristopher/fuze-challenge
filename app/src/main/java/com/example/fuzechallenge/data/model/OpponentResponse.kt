package com.example.fuzechallenge.data.model

import com.google.gson.annotations.SerializedName

class OpponentResponse(
    @SerializedName("opponent")
    val opponent: TeamResponse?,
    @SerializedName("type")
    val type: String?
)
