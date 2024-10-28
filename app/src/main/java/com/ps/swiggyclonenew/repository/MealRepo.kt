package com.ps.swiggyclonenew.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ps.swiggyclonenew.models.Category
import com.ps.swiggyclonenew.retrofit.MealAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MealRepo @Inject constructor(private val mealAPI: MealAPI) {

    private val _meals = MutableStateFlow<List<Category>>(emptyList())
    val meals: StateFlow<List<Category>> = _meals

    suspend fun getMeals(): List<Category> {
        // Call the API to get the meals category
        val result = mealAPI.getMealsCategory()

        // Check if the response is successful and contains a body
        val mealList = if (result.isSuccessful && result.body() != null) {
            // Extract categories from the response body
            result.body()!!.categories
        } else {
            emptyList() // Return an empty list in case of failure
        }

        // Update StateFlow with fetched data
        _meals.value = mealList
        return mealList
    }
}

