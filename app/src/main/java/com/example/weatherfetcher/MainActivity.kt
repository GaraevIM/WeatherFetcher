package com.example.weatherfetcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewHello = findViewById<TextView>(R.id.tvHello)
        textViewHello.text = "Hello from code!"

        val btnWeather = findViewById<Button>(R.id.btnWeather)
        btnWeather.setOnClickListener{
            Intent(this, WeatherActivity::class.java).also(::startActivity)
        }
    }
}