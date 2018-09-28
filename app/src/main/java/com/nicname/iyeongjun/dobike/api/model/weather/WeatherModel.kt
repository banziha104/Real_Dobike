package com.nicname.iyeongjun.dobike.api.model.weather

import com.google.gson.annotations.SerializedName
import com.nicname.iyeongjun.dobike.api.model.weather.Result

data class WeatherModel(
    @SerializedName("weather") val weather: Weather?,
    @SerializedName("common") val common: Common?,
    @SerializedName("result") val result: Result?
)