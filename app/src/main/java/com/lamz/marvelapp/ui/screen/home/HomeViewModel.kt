package com.lamz.marvelapp.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lamz.marvelapp.data.MarvelRepository
import com.lamz.marvelapp.model.Marvel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val repository: MarvelRepository
) : ViewModel() {

    private val _groupedAvengers = MutableStateFlow(
        repository.getAllMarvel()
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    )
    val getAllMarvel: StateFlow<Map<Char, List<Marvel>>> get() = _groupedAvengers


    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedAvengers.value = repository.searchMarvel(_query.value)
            .sortedBy { it.title }
            .groupBy { it.title[0] }
    }
}