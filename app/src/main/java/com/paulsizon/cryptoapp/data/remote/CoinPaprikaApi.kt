package com.paulsizon.cryptoapp.data.remote

import com.paulsizon.cryptoapp.data.remote.dto.CoinDetailDto
import com.paulsizon.cryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/{coinId}")
    suspend fun getCoinById(@Path("coinId") coindId: String): CoinDetailDto


}