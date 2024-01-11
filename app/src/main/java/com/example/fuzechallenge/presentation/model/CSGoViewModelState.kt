package com.example.fuzechallenge.presentation.model

sealed class CSGoViewModelState {
    object Initial : CSGoViewModelState()
    object Loading : CSGoViewModelState()
    data class Success(val gangs: List<GangUIModel>) : CSGoViewModelState()
    data class Error(val errorMessage: String? = null) : CSGoViewModelState()
}
