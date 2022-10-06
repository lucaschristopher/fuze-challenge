package com.example.fuzechallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fuzechallenge.core.constants.MATCH_MESSAGE_ERROR
import com.example.fuzechallenge.core.constants.UNIQUE_OPPONENTS_QUANTITY
import com.example.fuzechallenge.domain.model.detail.Gang
import com.example.fuzechallenge.domain.model.detail.toUiModel
import com.example.fuzechallenge.domain.usecase.GetTeamsInfoUseCase
import com.example.fuzechallenge.presentation.model.OpponentUiModel
import com.example.fuzechallenge.presentation.model.detail.GangUiModel
import com.example.fuzechallenge.presentation.state.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getTeamsInfoUseCase: GetTeamsInfoUseCase
) : ViewModel() {

    private val _teamsInfo =
        MutableStateFlow<ViewState<List<GangUiModel>>>(ViewState.Initial)
    val teamsInfo = _teamsInfo.asStateFlow()

    fun getTeamsInfo(opponents: List<OpponentUiModel>?) {
        viewModelScope.launch {
            if (opponents.isNullOrEmpty() || opponents.size == UNIQUE_OPPONENTS_QUANTITY) {
                _teamsInfo.value = ViewState.Error(Exception(MATCH_MESSAGE_ERROR))
            } else {
                getTeamsInfoUseCase(opponents.map { it.opponent.id })
                    .onStart { handleLoading() }
                    .catch { handleError(it) }
                    .collect { handleSuccess(it) }
            }
        }
    }

    private fun handleLoading() {
        _teamsInfo.value = ViewState.Loading
    }

    private fun handleError(throwable: Throwable) {
        _teamsInfo.value = ViewState.Error(throwable)
    }

    private fun handleSuccess(gangs: List<Gang>) {
        _teamsInfo.value = ViewState.Success(
            gangs.map { it.toUiModel() }
        )
    }
}