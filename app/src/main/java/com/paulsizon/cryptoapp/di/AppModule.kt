package com.paulsizon.cryptoapp.di

import com.paulsizon.cryptoapp.common.Constants
import com.paulsizon.cryptoapp.data.remote.CoinPaprikaApi
import com.paulsizon.cryptoapp.data.repository.CoinRepositoryImpl
import com.paulsizon.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePaprikaCoinApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }

}