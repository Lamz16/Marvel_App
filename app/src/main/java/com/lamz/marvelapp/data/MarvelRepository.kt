package com.lamz.marvelapp.data

import com.lamz.marvelapp.model.FakeMarvelDataSource
import com.lamz.marvelapp.model.Marvel
import com.lamz.marvelapp.model.MarvelData

class MarvelRepository {

    private val marvels = mutableListOf<MarvelData>()

    init {
        if (marvels.isEmpty()) {
            FakeMarvelDataSource.dummyMarvel.forEach {
                marvels.add(MarvelData(it, 0))
            }
        }
    }

    fun getAllMarvel(): List<Marvel> {
        return FakeMarvelDataSource.dummyMarvel
    }

    fun getMarvelDataById(marvelId: Long): MarvelData {
        return marvels.first {
            it.marvel.id == marvelId
        }
    }

    fun searchMarvel(query: String): List<Marvel>{
        return FakeMarvelDataSource.dummyMarvel.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: MarvelRepository? = null

        fun getInstance(): MarvelRepository =
            instance ?: synchronized(this) {
                MarvelRepository().apply {
                    instance = this
                }
            }
    }
}