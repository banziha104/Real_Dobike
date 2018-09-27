package com.nicname.iyeongjun.dobike.ui.fragments.weather

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class WeatherViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel() as T
    }
}