package com.example.fuzechallenge.presentation.commons.utils.extensions

fun String.onlyNumbers(): String {
    val re = Regex("[^0-9]")
    return re.replace(this, "")
}