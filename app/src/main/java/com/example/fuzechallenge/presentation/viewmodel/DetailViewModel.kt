package com.example.fuzechallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fuzechallenge.domain.model.detail.Gang
import com.example.fuzechallenge.domain.model.detail.toUiModel
import com.example.fuzechallenge.domain.usecase.AppUseCases
import com.example.fuzechallenge.presentation.model.detail.GangUiModel
import com.example.fuzechallenge.presentation.state.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DetailViewModel(
    private val appUseCases: AppUseCases
) : ViewModel() {

    var hasOpponents = false
    var hasFullOpponents = false

    private val _firstGangDetail = MutableStateFlow<ViewState<GangUiModel>>(ViewState.Initial)
    val firstGangDetail: StateFlow<ViewState<GangUiModel>>
        get() = _firstGangDetail

    private val _secondGangDetail = MutableStateFlow<ViewState<GangUiModel>>(ViewState.Initial)
    val secondGangDetail: StateFlow<ViewState<GangUiModel>>
        get() = _secondGangDetail

    fun getFirstGangDetail(id: String) {
        viewModelScope.launch {
            appUseCases.getGangByIdUseCase(id)
                .onStart { handleLoadingFirst() }
                .catch { handleErrorFirst(it) }
                .collect { handleSuccessFirst(it) }
        }
    }

    fun getSecondGangDetail(id: String) {
        viewModelScope.launch {
            appUseCases.getGangByIdUseCase(id)
                .onStart { handleLoadingSecond() }
                .catch { handleErrorSecond(it) }
                .collect { handleSuccessSecond(it) }
        }
    }

    private fun handleLoadingFirst() {
        _firstGangDetail.value = ViewState.Loading
    }

    private fun handleErrorFirst(throwable: Throwable) {
        _firstGangDetail.value = ViewState.Error(throwable)
    }

    private fun handleSuccessFirst(gang: Gang) {
        _firstGangDetail.value = ViewState.Success(gang.toUiModel())
    }

    private fun handleLoadingSecond() {
        _secondGangDetail.value = ViewState.Loading
    }

    private fun handleErrorSecond(throwable: Throwable) {
        _secondGangDetail.value = ViewState.Error(throwable)
    }

    private fun handleSuccessSecond(gang: Gang) {
        _secondGangDetail.value = ViewState.Success(gang.toUiModel())
    }
}