package com.maruf.cryptocurrency.data.remote

import com.maruf.cryptocurrency.common.Constants.COIN
import com.maruf.cryptocurrency.common.Constants.COIN_ID
import com.maruf.cryptocurrency.data.remote.dto.CoinDetailDto
import com.maruf.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Part

interface CoinPaprikaApi {
    @GET(COIN)
    suspend fun getCoins():List<CoinDto>

    @GET(COIN_ID)
    suspend fun getCoinById(@Part("coinId") coinId:String):CoinDetailDto
}