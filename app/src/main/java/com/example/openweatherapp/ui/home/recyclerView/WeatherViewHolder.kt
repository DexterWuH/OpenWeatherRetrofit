package com.example.openweatherapp.ui.home.recyclerView

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.R
import com.example.openweatherapp.data.WeatherResponse

class WeatherViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val numbersOfResults: TextView by lazy {
        itemView.findViewById(R.id.numbers_of_results)
    }
    private val dayTimeTextView: TextView by lazy {
        itemView.findViewById(R.id.daytime_textview)
    }
    private val weatherAverageTemperature: TextView by lazy {
        itemView.findViewById(R.id.average_temperature)
    }
    private val overallDescription: TextView by lazy {
        itemView.findViewById(R.id.overall_description_textview)
    }

    @SuppressLint("viewBond")
    fun bindModelToView(data: WeatherResponse) {
        numbersOfResults.text = "Number of results:${data.numberOfResults}"
        dayTimeTextView.text = "Day Time:${data.numberOfResults}"
        weatherAverageTemperature.text = "Average temperature:${data.numberOfResults}"
        overallDescription.text = "Overall Description:${data.numberOfResults}"
    }

}
