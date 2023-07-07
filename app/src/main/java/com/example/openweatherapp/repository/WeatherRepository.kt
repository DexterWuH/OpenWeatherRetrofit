package com.example.openweatherapp.repository

import com.example.openweatherapp.data.WeatherForcast
import com.example.openweatherapp.di.NetworkProvider
import com.example.openweatherapp.network.WeatherAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface WeatherRepositoryContract {
    suspend fun getWeather(): List<WeatherForcast>
}


class WeatherRepository(
    private val weatherAPI: WeatherAPI = NetworkProvider.weatherAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

) : WeatherRepositoryContract {
    override suspend fun getWeather(lat: Double, lon: Double): List<WeatherForcast> {
        return withContext(dispatcher) {
            val response = weatherAPI.getFiveDaysWeather(lat, lon)
            return@withContext response.forecasts

        }

    }

}

