package com.paulsizon.cryptoapp.domain.repository

import com.paulsizon.cryptoapp.data.remote.dto.CoinDetailDto
import com.paulsizon.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}