package com.example.fuzechallenge.presentation.commons.model

internal enum class MatchStatus(val status: String) {
    CANCELED("canceled"),
    FINISHED("finished"),
    NOT_STARTED("not_started"),
    RUNNING("running"),
    POSTPONED("postponed");
}
