package com.example.weatherfetcher

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class WeatherActivity : AppCompatActivity() {

    private val weatherPresenter = WeatherPresenter()

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        tvTemperature.text = weatherPresenter.getWeather(UUID.randomUUID().toString())

    }
}