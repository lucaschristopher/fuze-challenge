package com.example.fuzechallenge.presentation.detail.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fuzechallenge.domain.mapper.toUI
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.usecase.detail.GetMatchByIdUseCase
import com.example.fuzechallenge.presentation.commons.model.CSGoViewModelState
import com.example.fuzechallenge.presentation.commons.navigation.graph.MATCH_ID
import com.example.fuzechallenge.presentation.commons.utils.extensions.onlyNumbers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MatchDetailsViewModel @Inject constructor(
    private val getMatchByIdUseCase: GetMatchByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val matchId: String = checkNotNull(savedStateHandle[MATCH_ID])

    private val _state = MutableStateFlow<CSGoViewModelState>(CSGoViewModelState.Initial)
    val state = _state.asStateFlow()

    init {
        getMatchById()
    }

    private fun getMatchById() {
        viewModelScope.launch {
            getMatchByIdUseCase(matchId.onlyNumbers())
                .onStart { handleLoading() }
                .catch { handleError(it) }
                .collect { handleSuccess(it) }

        }
    }

    private fun handleLoading() {
        _state.update {
            CSGoViewModelState.Loading
        }
    }

    private fun handleError(throwable: Throwable) {
        _state.update {
            CSGoViewModelState.Error(throwable.message)
        }
    }

    private fun handleSuccess(match: Match) {
        _state.update {
            CSGoViewModelState.Success(match.toUI())
        }
    }
}
