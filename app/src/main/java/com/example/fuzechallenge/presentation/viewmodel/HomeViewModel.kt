package com.example.fuzechallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.fuzechallenge.domain.mapper.toUI
import com.example.fuzechallenge.domain.usecase.list.GetMatchesUseCase
import com.example.fuzechallenge.presentation.model.MatchUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    fun matchList(): Flow<PagingData<MatchUIModel>> = flow {
        getMatchesUseCase().collect {
            emit(it.map { match -> match.toUI() })
        }
    }.cachedIn(viewModelScope)
}
