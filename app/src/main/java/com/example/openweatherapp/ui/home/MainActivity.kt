package com.example.openweatherapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.openweatherapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

        private fun setInitialFragment() {
            val initialFragment = WeatherFragment()
            SetFragment(initialFragment)
        }

        private fun SetFragment(fragment: Fragment?){
            fragment?.let {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, it)
                .addToBackStack(null)
                .commit()

        }
    }


}




