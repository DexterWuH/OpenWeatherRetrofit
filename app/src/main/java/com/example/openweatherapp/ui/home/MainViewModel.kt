package com.example.openweatherapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.data.WeatherResponse
import com.example.openweatherapp.repository.WeatherRepositoryContract
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(
    private val weatherRepository: WeatherRepositoryContract
) : ViewModel() {

    val weatherResponse = MutableLiveData<List<WeatherResponse>>()
    fun fetchWeather() {
        viewModelScope.launch{
            val response = weatherRepository.getWeather(44.34, 10.99)
            weatherResponse.postValue(response)
            Log.d("MainViewModel", "$response")
        }
    }
}
