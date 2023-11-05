package com.lamz.marvelapp.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lamz.marvelapp.data.MarvelRepository
import com.lamz.marvelapp.ui.common.UiState
import com.lamz.marvelapp.ui.screen.favorite.CartState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: MarvelRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrderRewards() {
        viewModelScope.launch {
//            _uiState.value = UiState.Loading
//            repository.getAddedAvengersData()
//                .collect { orderReward ->
//                    val totalRequiredPoint =
//                        orderReward.sumOf { it.avengers.requiredPoint * it.count }
//                    _uiState.value = UiState.Success(CartState(orderReward, totalRequiredPoint))
//                }
        }
    }

    fun updateOrderReward(rewardId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateMarvelData(rewardId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderRewards()
                    }
                }
        }
    }
}