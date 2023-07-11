package com.example.openweatherapp.ui.home.recyclerView

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.R
import com.example.openweatherapp.data.DayConditions

class WeatherViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val minimumTemperature: TextView by lazy {
        itemView.findViewById(R.id.average_Temp_textview)
    }
    private val humidity: TextView by lazy {
        itemView.findViewById(R.id.humidity_textview)
    }
    private val MaximumTemperature: TextView by lazy {
        itemView.findViewById(R.id.feels_like_textview)
    }

    @SuppressLint("viewBond")
    fun bindModelToView(data: DayConditions) {
        minimumTemperature.text = "Minimum Temperature:${data.minTemperature}"
        humidity.text =
            "Humidity:${data.humidity}"
        MaximumTemperature.text =
            "Max Temperature:${data.maxTemperature}"
    }

}
