package com.example.fuzechallenge.commons.constants

internal object Constants {

    // Utils
    const val EMPTY_STRING = ""
    const val MATCH_MESSAGE_ERROR = "Partida não iniciada ou postergada."
    const val SPACE_STRING = " "
    const val SORT_PARAM = "-status"
    const val NO_TIME = "--:--"
    const val DATE_SINGLE_PATTERN = "E, HH:mm"
    const val DATE_COMPLEX_PATTERN = "yyyy/MM/dd HH:mm:ss"
    const val ZONE_ID = "Brazil/East"
    const val ZONE_OFFSET = -3
    const val LANGUAGE = "pt"
    const val COUNTRY = "pt-Br"

    // Long
    const val DEFAULT_ID: Long = 0
    const val DEFAULT_TIME_VALUE: Long = 60
    const val ANIMATION_DURATION: Long = 3000L

    // Int
    const val ONE: Int = 1
    const val TWO: Int = 2
    const val INITIAL_PAGE: Int = 1
    const val INITIAL_INDEX: Int = 0
    const val PAGE_SIZE: Int = 20
    const val FULL_OPPONENTS_QUANTITY: Int = 2
    const val MAX_LINES: Int = 1
    const val CANVA_DIVISOR: Int = 2
    const val SIZE_TO_ELLIPSIS: Int = 12
    const val TEST_NEXT_PAGE = 2

    // Interceptor
    const val AUTHORIZATION = "Authorization"

    // Test tags
    const val APP_TOP_BAR_COMPONENT = "APP_TOP_BAR_COMPONENT"
}