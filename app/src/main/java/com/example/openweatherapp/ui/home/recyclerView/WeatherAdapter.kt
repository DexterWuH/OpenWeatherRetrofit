package com.example.openweatherapp.ui.home.recyclerView

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import com.example.openweatherapp.R
import com.example.openweatherapp.data.DayConditions

class WeatherAdapter(weatherForecast: List<DayConditions>) : androidx.recyclerview.widget.RecyclerView.Adapter<WeatherViewHolder>() {

private val dayConditions:MutableList<DayConditions> = mutableListOf<DayConditions>().apply {
    addAll(weatherForecast)
}

    @SuppressLint
    fun refreshWeatherList(newDayConditions: List<DayConditions>){
        dayConditions.clear()
        dayConditions.addAll(newDayConditions)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = View.inflate(parent.context, R.layout.recycler_viewholder_weather, null)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bindModelToView(dayConditions[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return dayConditions.size
    }


}