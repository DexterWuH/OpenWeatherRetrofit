package com.example.openweatherapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.R
import com.example.openweatherapp.repository.WeatherRepository
import com.example.openweatherapp.repository.WeatherRepositoryContract
import com.example.openweatherapp.ui.home.recyclerView.WeatherAdapter


class WeatherFragment : Fragment(){

    private val weatherRepository: WeatherRepositoryContract by lazy {
        WeatherRepository()
    }

    private lateinit var recyclerView: RecyclerView
    private val mainViewModel = MainViewModel(weatherRepository)
    private val adapter = WeatherAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=requireView().findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
        recyclerView.adapter=adapter
        mainViewModel.fetchWeather()
        observeResults()
    }
    private fun observeResults(){
        mainViewModel.dayCondition.observe(viewLifecycleOwner){
            adapter.refreshWeatherList(it)

        }
    }
}

