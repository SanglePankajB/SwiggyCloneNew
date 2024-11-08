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

