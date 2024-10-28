package com.ps.swiggyclonenew.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ps.swiggyclonenew.models.Category
import com.ps.swiggyclonenew.repository.MealRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// we cannot inject dependencies into the viewmodel directly cause it itself implements ViewModel() so we provide dependencies through factory
// but hilt simplifies it with @HiltViewModel

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MealRepo) : ViewModel() {

    private val _mealStateFlow = MutableStateFlow<List<Category>>(emptyList())
    val mealStateFlow: StateFlow<List<Category>> = _mealStateFlow

    init {
        viewModelScope.launch {
            _mealStateFlow.value = repo.getMeals()
        }
    }
}
