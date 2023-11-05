package com.lamz.marvelapp.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lamz.marvelapp.data.MarvelRepository
import com.lamz.marvelapp.model.Marvel
import com.lamz.marvelapp.model.MarvelData
import com.lamz.marvelapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailRewardViewModel(
    private val repository: MarvelRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<MarvelData>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<MarvelData>>
        get() = _uiState

    fun getRewardById(rewardId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getMarvelDataById(rewardId))
        }
    }
}