package com.example.fuzechallenge.presentation.commons.model

import com.example.fuzechallenge.presentation.list.model.MatchUIModel

internal sealed class CSGoViewModelState { // FIXME
    object Initial : CSGoViewModelState()
    object Loading : CSGoViewModelState()
    data class Success(val match: MatchUIModel) : CSGoViewModelState()
    data class Error(val errorMessage: String? = null) : CSGoViewModelState()
}
