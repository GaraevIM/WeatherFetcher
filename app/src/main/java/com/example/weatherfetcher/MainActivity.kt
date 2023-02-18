package com.example.weatherfetcher

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.weatherfetcher.feature.weather_screen.ui.UiEvent
import com.example.weatherfetcher.feature.weather_screen.ui.ViewState
import com.example.weatherfetcher.feature.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()

    private val textViewHello: TextView by lazy {findViewById(R.id.tvHello)}
    private val fabWeather: FloatingActionButton by lazy {findViewById(R.id.fabWeatherFetch)}
    private val progressBar: ProgressBar by lazy {findViewById(R.id.progressBar)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this, ::render)

        fabWeather.setOnClickListener{
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }
    }

    private fun render (viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        textViewHello.text = "${viewState.title} ${viewState.temperature}"
    }
}