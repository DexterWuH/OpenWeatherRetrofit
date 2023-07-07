package com.example.openweatherapp.data

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("cnt")
    val numberOfResults: Int,
    val forecasts: List<WeatherForcast>
)


data class DayConditions(
    @SerializedName("temp")
    val averageTemperature: Double,
    val feels_like: Double,
    @SerializedName("temp_min")
    val minTemperature: Double,
    @SerializedName("temp_max")
    val maxTemperature: Double,
    @SerializedName("humidity")
    val humidity: Int
)


data class WeatherForcast(
    @SerializedName("dt")
    val dayTime: Long,
    @SerializedName("main")
    val dayConditions: DayConditions,
    @SerializedName("weather")
    val descriptions: List<WeatherDescription>

)

data class WeatherDescription(
    @SerializedName("main")
    val overallWeatherCondition: String,
    @SerializedName("description")
    val detailedDescription: String
)