package com.example.fuzechallenge.domain.usecase

import androidx.paging.PagingData
import com.example.fuzechallenge.data.repository.AppRepository
import com.example.fuzechallenge.domain.model.Match
import kotlinx.coroutines.flow.Flow

class GetMatchesUseCase(private val repository: AppRepository) {
    operator fun invoke(): Flow<PagingData<Match>> {
        return this.repository.getMatches()
    }
}
