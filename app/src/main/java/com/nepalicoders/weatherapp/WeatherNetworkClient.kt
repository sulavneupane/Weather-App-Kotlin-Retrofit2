package com.nepalicoders.weatherapp

import android.content.Context
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sulav on 9/9/17.
 */
class WeatherNetworkClient(val context: Context) {
    val apiKey = context.resources.getString(R.string.api_key)

    fun getWeatherForZipCode(zipcode: Int): Call<Weather> {
        val network = Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val weatherServices = network.create(WeatherService::class.java)
        val weather = weatherServices.weatherByZip("imperial", zipcode, apiKey)
        return weather
    }
}