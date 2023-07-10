package com.example.openweatherapp.repository

import com.example.openweatherapp.data.WeatherForecast
import com.example.openweatherapp.data.WeatherResponse
import com.example.openweatherapp.di.NetworkProvider
import com.example.openweatherapp.network.WeatherAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface WeatherRepositoryContract {
    suspend fun getWeather(lat: Double, lon: Double): List<WeatherResponse>
}

class WeatherRepository(
    private val weatherAPI: WeatherAPI = NetworkProvider.weatherAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : WeatherRepositoryContract {
    override suspend fun getWeather(lat: Double, lon: Double): List<WeatherResponse> {
        return withContext(dispatcher) {
            val response = weatherAPI.getWeather(lat, lon)
            return@withContext listOf(response)
        }
    }
}