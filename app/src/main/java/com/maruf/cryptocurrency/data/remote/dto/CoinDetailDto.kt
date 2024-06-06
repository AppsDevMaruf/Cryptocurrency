package com.maruf.cryptocurrency.data.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.maruf.cryptocurrency.domain.model.CoinDetail

@Keep
data class CoinDetailDto(
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    val whitepaper: Whitepaper
) {
    @Keep
    data class Links(
        @SerializedName("explorer")
        val explorer: List<String?>?,
        @SerializedName("facebook")
        val facebook: List<String?>?,
        @SerializedName("reddit")
        val reddit: List<String?>?,
        @SerializedName("source_code")
        val sourceCode: List<String?>?,
        @SerializedName("website")
        val website: List<String?>?,
        @SerializedName("youtube")
        val youtube: List<String?>?
    )

    @Keep
    data class LinksExtended(
        @SerializedName("stats")
        val stats: Stats?,
        @SerializedName("type")
        val type: String?,
        @SerializedName("url")
        val url: String?
    ) {
        @Keep
        data class Stats(
            @SerializedName("contributors")
            val contributors: Int?,
            @SerializedName("followers")
            val followers: Int?,
            @SerializedName("stars")
            val stars: Int?,
            @SerializedName("subscribers")
            val subscribers: Int?
        )
    }

    @Keep
    data class Tag(
        @SerializedName("coin_counter")
        val coinCounter: Int,
        @SerializedName("ico_counter")
        val icoCounter: Int,
        @SerializedName("id")
        val id: String?,
        @SerializedName("name")
        val name: String
    )

    @Keep
    data class Team(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("position")
        val position: String
    )

    @Keep
    data class Whitepaper(
        @SerializedName("link")
        val link: String?,
        @SerializedName("thumbnail")
        val thumbnail: String?
    )

}
fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}
