package com.ps.swiggyclonenew.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ps.swiggyclonenew.intent.MyIntent
import com.ps.swiggyclonenew.intent.UIEvent
import com.ps.swiggyclonenew.models.Category
import com.ps.swiggyclonenew.models.Restaurent
import com.ps.swiggyclonenew.models.Restaurents
import com.ps.swiggyclonenew.repository.MealRepo
import com.ps.swiggyclonenew.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// we cannot inject dependencies into the viewmodel directly cause it itself implements ViewModel() so we provide dependencies through factory
// but hilt simplifies it with @HiltViewModel

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MealRepo
) : ViewModel() {

    private val _mealStateFlow = MutableStateFlow<List<Category>>(emptyList())
    val mealStateFlow: StateFlow<List<Category>> = _mealStateFlow
    private val _restoStateFlow = MutableStateFlow<List<Restaurents>>(emptyList())
    val restoStateFlow: StateFlow<List<Restaurents>> = _restoStateFlow

    private val _uiEvent = MutableSharedFlow<UIEvent>()
    val uiEvent: SharedFlow<UIEvent> = _uiEvent

    private val _filteredRestaurents = MutableStateFlow<List<Restaurents>>(emptyList())
    val filteredRestaurents: StateFlow<List<Restaurents>> = _filteredRestaurents


    init {
        viewModelScope.launch {
            _mealStateFlow.value = repo.getMeals()
            _restoStateFlow.value = repo.getRestaurent()
        }
    }
    fun onEvent(intent: MyIntent) {
        when (intent) {
            is MyIntent.Search -> {
                viewModelScope.launch {
                    println("The intent action executed......")
                    filterRestaurents(intent.query)
//                    _uiEvent.emit(UIEvent.Navigate(Screen.RestaurentFilterScreen.route))
                }
            }
        }
    }


    private fun filterRestaurents(query: String) {
        viewModelScope.launch {
            val allRestaurents = _restoStateFlow.value
            _filteredRestaurents.value = allRestaurents.filter { it.restSubTitle.contains(query, ignoreCase = true) || it.restName.contains(query, ignoreCase = true) }
        }
    }

}
