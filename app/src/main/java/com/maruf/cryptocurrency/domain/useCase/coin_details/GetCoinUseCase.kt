package com.maruf.cryptocurrency.domain.useCase.coin_details

import com.maruf.cryptocurrency.common.Resource
import com.maruf.cryptocurrency.data.remote.dto.toCoinDetail
import com.maruf.cryptocurrency.domain.model.CoinDetail
import com.maruf.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
