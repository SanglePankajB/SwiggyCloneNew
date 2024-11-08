package com.ps.swiggyclonenew.retrofit

import com.ps.swiggyclonenew.models.CategoryResponse
import com.ps.swiggyclonenew.models.Restaurent
import retrofit2.Response
import retrofit2.http.GET

interface MealAPI {

    @GET("categories.php")
    suspend fun  getMealsCategory() : Response<CategoryResponse>

    @GET("restaurents")
    suspend fun  getRestaurants() : Response<Restaurent>
}