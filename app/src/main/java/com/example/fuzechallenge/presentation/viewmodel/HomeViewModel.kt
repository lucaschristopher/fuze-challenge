package com.example.fuzechallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.fuzechallenge.domain.model.toUiModel
import com.example.fuzechallenge.domain.usecase.AppUseCases
import com.example.fuzechallenge.presentation.model.MatchUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeViewModel(
    private val appUseCases: AppUseCases
) : ViewModel() {

    fun matchList(): Flow<PagingData<MatchUiModel>> = flow {
        appUseCases.getMatchesUseCase().collect {
            emit(it.map { match -> match.toUiModel() })
        }
    }.cachedIn(viewModelScope)
}