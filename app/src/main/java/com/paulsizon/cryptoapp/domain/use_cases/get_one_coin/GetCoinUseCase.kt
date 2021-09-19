package com.paulsizon.cryptoapp.domain.use_cases.get_one_coin

import com.paulsizon.cryptoapp.common.Resource
import com.paulsizon.cryptoapp.data.remote.dto.toCoin
import com.paulsizon.cryptoapp.data.remote.dto.toCoinDetail
import com.paulsizon.cryptoapp.domain.model.Coin
import com.paulsizon.cryptoapp.domain.model.CoinDetail
import com.paulsizon.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

//todo string res

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository ){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage?: "Could not reach server, please check your connection"))
        }
    }
}