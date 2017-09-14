package com.nepalicoders.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val DEGREE: String = "°"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zipCodeText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(edit: Editable?) {
                val zipcode = edit.toString()
                if (zipcode.length == 5) {
                    getWeatherFromZipCode(zipcode.toInt())
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

    }

    fun getWeatherFromZipCode(zipCode: Int) {
        val network = WeatherNetworkClient(applicationContext)
        val call = network.getWeatherForZipCode(zipCode)
        call.enqueue(object : Callback<Weather> {
            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                if (response != null) {
                    val weather: Weather? = response?.body()
                    val main = weather?.main
                    main?.let { presentData(it) }
                }
            }

        })
    }

    private fun presentData(main: Main) {
        with(main) {
            currentTemp.text = "$temp$DEGREE"
            lowTemp.text = "Low: $minTemp$DEGREE"
            highTemp.text = "High: $maxTemp$DEGREE"
        }
    }
}
