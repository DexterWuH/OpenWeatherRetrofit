package com.example.openweatherapp.di

import com.example.openweatherapp.BuildConfig
import com.example.openweatherapp.network.WeatherAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkProvider {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private const val API_KEY = "appid"

    private val keyInterceptor: Interceptor = Interceptor { chain ->
        val request = chain.request()
        val url = request.url.newBuilder().addQueryParameter(API_KEY, BuildConfig.API_KEY).build()
        chain.proceed(request.newBuilder().url(url).build())
    }

    private val logInterceptor: Interceptor = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) {
            apply { level = HttpLoggingInterceptor.Level.BODY }
        } else {
            apply { level = HttpLoggingInterceptor.Level.NONE }
        }
    }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor(keyInterceptor)
            .addNetworkInterceptor(logInterceptor)
            .connectTimeout(5, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherAPI: WeatherAPI by lazy {
        retrofit.create(WeatherAPI::class.java)
    }
}