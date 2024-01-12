package com.example.fuzechallenge.presentation.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.fuzechallenge.domain.mapper.toUI
import com.example.fuzechallenge.domain.usecase.list.GetMatchesUseCase
import com.example.fuzechallenge.presentation.list.model.MatchUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MatchListViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<PagingData<MatchUIModel>> =
        MutableStateFlow(value = PagingData.empty())

    val state = _state.asStateFlow()

    init {
        this.getMatches()
    }

    private fun getMatches() {
        viewModelScope.launch {
            getMatchesUseCase()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    _state.value = it.map { match -> match.toUI() }
                }
        }
    }
}
