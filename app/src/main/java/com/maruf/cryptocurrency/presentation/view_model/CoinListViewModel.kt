package com.maruf.cryptocurrency.presentation.view_model

import androidx.lifecycle.ViewModel
import com.maruf.cryptocurrency.domain.useCase.coin_list.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) : ViewModel() {

}