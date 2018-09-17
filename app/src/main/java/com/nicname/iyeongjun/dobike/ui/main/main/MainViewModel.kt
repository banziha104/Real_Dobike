package com.nicname.iyeongjun.dobike.ui.main.main

import android.arch.lifecycle.ViewModel
import com.nicname.iyeongjun.dobike.adapter.recycler.inter.LocationApi
import com.nicname.iyeongjun.dobike.adapter.recycler.inter.StorageApi
import com.nicname.iyeongjun.dobike.adapter.recycler.inter.ThemeApi
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi

// 메인 뷰모델
class MainViewModel(var tourApi: TourApi,
                    var weatherApi: WeatherApi,
                    var storageApi: StorageApi,
                    var locationApi: LocationApi,
                    var themeApi: ThemeApi) : ViewModel(){
}