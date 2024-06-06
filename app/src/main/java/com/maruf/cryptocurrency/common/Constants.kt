package com.maruf.cryptocurrency.common

import com.maruf.cryptocurrency.domain.model.Coin


object Constants {
    private const val VERSION = "v1"
    const val COIN = "coins"
    const val COIN_ID = "$COIN/{coinId}"
    const val BASE_URL = "https://api.coinpaprika.com/$VERSION"
}