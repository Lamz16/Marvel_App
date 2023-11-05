package com.lamz.marvelapp.data

import com.lamz.marvelapp.model.FakeMarvelDataSource
import com.lamz.marvelapp.model.Marvel
import com.lamz.marvelapp.model.MarvelData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

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

    fun getMarvelDataById(MarvelId: Long): MarvelData {
        return marvels.first {
            it.marvel.id == MarvelId
        }
    }

    fun updateMarvelData(MarvelId: Long, newCountValue: Int): Flow<Boolean> {
        val index = marvels.indexOfFirst { it.marvel.id == MarvelId }
        val result = if (index >= 0) {
            val MarvelData = marvels[index]
            marvels[index] =
                MarvelData.copy(marvel = MarvelData.marvel, count = newCountValue)
            true
        } else {
            false
        }
        return flowOf(result)
    }

//    fun getAddedMarvelData(): Flow<List<MarvelData>> {
//        return getAllMarvel()
//            .map { orderRewards ->
//                orderRewards.filter { orderReward ->
//                    orderReward.count != 0
//                }
//            }
//    }

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