package com.nepalicoders.weatherapp

import com.google.gson.annotations.SerializedName

/**
 * Created by Sulav on 9/9/17.
 */
class Weather {
    var main: Main = Main()
}

class Main {
    var temp: Float = 0.0f
    @SerializedName("temp_min")
    var minTemp: Float = 0.0f
    @SerializedName("temp_max")
    var maxTemp: Float = 0.0f
}