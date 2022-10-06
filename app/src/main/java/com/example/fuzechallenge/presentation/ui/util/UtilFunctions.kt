package com.example.fuzechallenge.presentation.ui.util

import android.content.Context
import android.widget.Toast
import com.example.fuzechallenge.R

fun showToast(context: Context) {
    Toast.makeText(context, R.string.error_toast_message, Toast.LENGTH_LONG).show()
}

