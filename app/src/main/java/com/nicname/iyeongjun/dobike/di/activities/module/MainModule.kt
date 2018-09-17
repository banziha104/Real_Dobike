package com.nicname.iyeongjun.dobike.di.activities.module

import com.nicname.iyeongjun.dobike.adapter.recycler.inter.LocationApi
import com.nicname.iyeongjun.dobike.adapter.recycler.inter.StorageApi
import com.nicname.iyeongjun.dobike.adapter.recycler.inter.ThemeApi
import com.nicname.iyeongjun.dobike.ui.main.main.MainViewModelFactory
import com.nicname.iyeongjun.gwangju_contest.api.inter.TourApi
import com.nicname.iyeongjun.gwangju_contest.api.inter.WeatherApi
import dagger.Module
import dagger.Provides


// 메인 액티비티에 주입되는 모듈
@Module
class MainModule{
    @Provides
    fun provideMainViewModelFactory(tourApi: TourApi,
                                    weatherApi: WeatherApi,
                                    storageApi: StorageApi,
                                    locationApi: LocationApi,
                                    themeApi: ThemeApi) = MainViewModelFactory(tourApi,weatherApi,storageApi,locationApi,themeApi)
}