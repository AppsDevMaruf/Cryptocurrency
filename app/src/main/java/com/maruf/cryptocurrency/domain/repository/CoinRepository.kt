package com.maruf.cryptocurrency.domain.repository

import com.maruf.cryptocurrency.data.remote.dto.CoinDetailDto
import com.maruf.cryptocurrency.data.remote.dto.CoinDto


interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}