package com.lamz.marvelapp.ui.screen.favorite

import com.lamz.marvelapp.model.MarvelData


data class CartState(
    val marvelData: List<MarvelData>,
    val totalRequiredPoint: Int
)