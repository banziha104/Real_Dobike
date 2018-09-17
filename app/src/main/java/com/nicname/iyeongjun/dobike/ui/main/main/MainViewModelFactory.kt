package com.nicname.iyeongjun.dobike.ui.main.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.nicname.iyeongjun.dobike.adapter.recycler.inter.LocationApi
import com.nicname.iyeongjun.dobike.adapter.recycler.inter.StorageApi
import com.nicname.iyeongjun.dobike.adapter.recycler.inter.ThemeApi
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi

// ViewModel을 만드는 뷰모델 팩토리

class MainViewModelFactory(var tourApi: TourApi,
                           var weatherApi: WeatherApi,
                           var storageApi: StorageApi,
                           var locationApi: LocationApi,
                           var themeApi: ThemeApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(tourApi, weatherApi, storageApi, locationApi,themeApi) as T
    }
}