package com.paulsizon.cryptoapp.data.repository

import com.paulsizon.cryptoapp.data.remote.CoinPaprikaApi
import com.paulsizon.cryptoapp.data.remote.dto.CoinDetailDto
import com.paulsizon.cryptoapp.data.remote.dto.CoinDto
import com.paulsizon.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(private val api: CoinPaprikaApi):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}