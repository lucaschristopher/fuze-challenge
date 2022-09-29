package com.example.fuzechallenge.core.enum

enum class MatchStatus(val status: String) {
    CANCELED("canceled"),
    FINISHED("finished"),
    NOT_STARTED("not_started"),
    POSTPONED("postponed"),
    RUNNING("running")
}
