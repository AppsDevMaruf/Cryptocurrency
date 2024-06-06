package com.maruf.cryptocurrency.domain.model
import com.maruf.cryptocurrency.data.remote.dto.CoinDetailDto

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<CoinDetailDto.Team>
)
