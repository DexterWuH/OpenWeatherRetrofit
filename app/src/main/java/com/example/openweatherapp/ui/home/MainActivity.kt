package com.example.openweatherapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.openweatherapp.R
import com.example.openweatherapp.di.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainViewModel.doSomething()
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




