package com.ps.swiggyclonenew.models

import androidx.compose.ui.Modifier

data class Restaurent(
    val restaurent: List<Restaurents>
)

data class Restaurents(
    val idRes: String,
    val restDeleveryType: String,
    val restLocation: String,
    val restName: String,
    val restRating: String,
    val restSubTitle: String,
    val restThubnail: String,
    val restServeTime: String
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
