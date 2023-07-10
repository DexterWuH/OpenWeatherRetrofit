package com.example.openweatherapp.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.repository.WeatherRepositoryContract
import kotlinx.coroutines.launch
import java.security.PrivateKey

class MainViewModel(
    private val weatherRepository: WeatherRepositoryContract,


    ): ViewModel() {






    fun doSomething() {
        viewModelScope.launch {
            val response = weatherRepository.getWeather(lat = 44.34, lon = 10.99)
            Log.d("MainViewModel", "${response}")
        }
    }
}