package com.maruf.cryptocurrency.domain.useCase.coin_list

import coil.network.HttpException
import com.maruf.cryptocurrency.common.Resource
import com.maruf.cryptocurrency.data.remote.dto.toCoin
import com.maruf.cryptocurrency.domain.model.Coin
import com.maruf.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server.Please check your internet connection"))
        }
    }

}