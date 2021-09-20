package com.paulsizon.cryptoapp.presentation.coins_list

import com.paulsizon.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error: String = ""
)
