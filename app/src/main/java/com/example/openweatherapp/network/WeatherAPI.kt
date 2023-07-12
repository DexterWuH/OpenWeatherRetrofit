package com.example.openweatherapp.network

import com.example.openweatherapp.data.DayConditions
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("forecast")
    suspend fun getWeather(@Query("lat") lat: Double, @Query("lon") lon: Double): DayConditions
}