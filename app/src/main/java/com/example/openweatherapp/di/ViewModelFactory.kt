package com.example.openweatherapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.openweatherapp.repository.WeatherRepository
import com.example.openweatherapp.repository.WeatherRepositoryContract
import com.example.openweatherapp.ui.home.MainViewModel

object ViewModelFactory : ViewModelProvider.Factory {

    private val weatherRepository: WeatherRepositoryContract by lazy {
        WeatherRepository()
    }

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom((MainViewModel::class.java))) {
            return MainViewModel(weatherRepository) as T
        }
        throw  IllegalAccessException("must provide a ViewModel")
    }
}