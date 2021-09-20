package com.paulsizon.cryptoapp.presentation.coins_detail

import com.paulsizon.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
