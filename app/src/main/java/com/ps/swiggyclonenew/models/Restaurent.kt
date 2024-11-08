package com.ps.swiggyclonenew.models

import androidx.compose.ui.Modifier


data class CategoryResponse(
    val categories: List<Category>
)

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

data class RestaurantParam(
    val title: String,
    val rating: String,
    val timeToServe: String,
    val subTitle: String? = null,
    val location: String,
    val deliveryType: String? = null,
    val imageResource: String,
)
