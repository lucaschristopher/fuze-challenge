package com.example.fuzechallenge.domain.usecase.list

import androidx.paging.PagingData
import com.example.fuzechallenge.domain.model.Match
import com.example.fuzechallenge.domain.repository.CSGoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal interface GetMatchesUseCase {
    suspend operator fun invoke(): Flow<PagingData<Match>>

}

internal class GetMatchesUseCaseImpl @Inject constructor(
    private val repository: CSGoRepository
) : GetMatchesUseCase {
    override suspend operator fun invoke(): Flow<PagingData<Match>> {
        return this.repository.getMatches()
    }
}
