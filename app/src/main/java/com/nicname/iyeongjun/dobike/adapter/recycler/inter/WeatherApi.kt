package com.nicname.iyeongjun.gwangju_contest.api.inter

import com.nicname.iyeongjun.dobike.const.T_KEY
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {
    @Headers("Accept: application/json",
            "Content-type:application/json",
            "appKey:${T_KEY}")
    @GET("weather/current/hourly")
    fun getWeather(
                   @Query("lat") lat : String,
                   @Query("lon") lon : String,
                   @Query("version") version : Int = 2) : Observable<WeatherModel>
}
