package com.example.openweatherapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.data.DayConditions
import com.example.openweatherapp.data.WeatherForecast
import com.example.openweatherapp.repository.WeatherRepositoryContract
import kotlinx.coroutines.launch

class MainViewModel(
    private val weatherRepository: WeatherRepositoryContract
) : ViewModel() {

    val dayCondition = MutableLiveData<List<DayConditions>>()
    fun fetchWeather() {
        viewModelScope.launch{
            val response = weatherRepository.getWeather(44.34, 10.99)
            dayCondition.postValue(response)
            Log.d("MainViewModel", "$response")
        }
    }
}
