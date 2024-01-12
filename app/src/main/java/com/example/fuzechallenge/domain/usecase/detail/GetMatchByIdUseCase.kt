package com.example.fuzechallenge.domain.usecase.detail

import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.repository.CSGoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal interface GetMatchByIdUseCase {
    suspend operator fun invoke(matchId: String): Flow<Match>
}

internal class GetMatchByIdUseCaseImpl @Inject constructor(
    private val repository: CSGoRepository
) : GetMatchByIdUseCase {
    override suspend operator fun invoke(matchId: String): Flow<Match> {
        return this.repository.getMatchById(matchId)
    }
}