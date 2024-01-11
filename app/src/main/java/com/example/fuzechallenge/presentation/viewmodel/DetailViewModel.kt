package com.example.fuzechallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fuzechallenge.commons.constants.Constants
import com.example.fuzechallenge.domain.mapper.toUI
import com.example.fuzechallenge.domain.model.Gang
import com.example.fuzechallenge.domain.usecase.detail.GetTeamsInfoUseCase
import com.example.fuzechallenge.presentation.model.CSGoViewModelState
import com.example.fuzechallenge.presentation.model.OpponentUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DetailViewModel @Inject constructor(
    private val getTeamsInfoUseCase: GetTeamsInfoUseCase
) : ViewModel() {

    private val _teamsInfo = MutableStateFlow<CSGoViewModelState>(CSGoViewModelState.Initial)
    val teamsInfo = _teamsInfo.asStateFlow() // FIXME

    fun getTeamsInfo(opponents: List<OpponentUIModel>?) { // FIXME
        viewModelScope.launch {
            if (opponents.isNullOrEmpty() || opponents.size == Constants.UNIQUE_OPPONENTS_QUANTITY) {
                _teamsInfo.value = CSGoViewModelState.Error()
            } else {
                getTeamsInfoUseCase(opponents.map { it.opponent.id })
                    .onStart { handleLoading() }
                    .catch { handleError(it) }
                    .collect { handleSuccess(it) }
            }
        }
    }

    private fun handleLoading() {
        _teamsInfo.update {
            CSGoViewModelState.Loading
        }
    }

    private fun handleError(throwable: Throwable) {
        _teamsInfo.update {
            CSGoViewModelState.Error(throwable.message)
        }
    }

    private fun handleSuccess(gangs: List<Gang>) {
        _teamsInfo.update {
            CSGoViewModelState.Success(gangs.map { it.toUI() })
        }
    }
}
