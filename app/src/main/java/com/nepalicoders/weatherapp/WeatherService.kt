package com.nepalicoders.weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sulav on 9/9/17.
 */
interface WeatherService {
    @GET("/data/2.5/weather")
    fun weatherByZip(@Query("units") units: String, @Query("zip") zip: Int, @Query("APPID") apiKey: String): Call<Weather>
}