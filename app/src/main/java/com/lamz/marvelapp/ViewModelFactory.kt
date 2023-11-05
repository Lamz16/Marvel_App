package com.lamz.marvelapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lamz.marvelapp.ui.screen.home.HomeViewModel
import com.lamz.marvelapp.data.MarvelRepository
import com.lamz.marvelapp.ui.screen.detail.DetailRewardViewModel

class ViewModelFactory(private val repository: MarvelRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailRewardViewModel::class.java)) {
            return DetailRewardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}