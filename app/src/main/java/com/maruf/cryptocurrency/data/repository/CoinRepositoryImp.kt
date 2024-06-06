package com.maruf.cryptocurrency.data.repository

import com.maruf.cryptocurrency.data.remote.CoinPaprikaApi
import com.maruf.cryptocurrency.data.remote.dto.CoinDetailDto
import com.maruf.cryptocurrency.data.remote.dto.CoinDto
import com.maruf.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}