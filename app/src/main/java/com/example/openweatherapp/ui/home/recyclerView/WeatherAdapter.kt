package com.example.openweatherapp.ui.home.recyclerView

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import com.example.openweatherapp.R
import com.example.openweatherapp.data.WeatherResponse

class WeatherAdapter(weatherResponse: List<WeatherResponse>) : androidx.recyclerview.widget.RecyclerView.Adapter<WeatherViewHolder>() {

private val weatherResponse:MutableList<WeatherResponse> = mutableListOf<WeatherResponse>().apply {
    addAll(weatherResponse)
}

    @SuppressLint
    fun refreshWeatherList(newWeatherResponse: List<WeatherResponse>){
        weatherResponse.clear()
        weatherResponse.addAll(newWeatherResponse)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = View.inflate(parent.context, R.layout.recycler_viewholder_weather, null)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bindModelToView(weatherResponse[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return weatherResponse.size
    }


}