package com.lamz.marvelapp.di

import com.lamz.marvelapp.data.MarvelRepository


object Injection {
    fun provideRepository(): MarvelRepository {
        return MarvelRepository.getInstance()
    }
}