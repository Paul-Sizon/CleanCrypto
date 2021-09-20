package com.paulsizon.cryptoapp.domain.use_cases.get_all_coins

import com.paulsizon.cryptoapp.common.Resource
import com.paulsizon.cryptoapp.data.remote.dto.toCoin
import com.paulsizon.cryptoapp.domain.model.Coin
import com.paulsizon.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

//todo string res

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository ){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }
}