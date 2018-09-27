package com.nicname.iyeongjun.dobike.driver

import com.nicname.iyeongjun.dobike.adapter.recycler.model.location.LocationModel
import com.nicname.iyeongjun.dobike.adapter.recycler.model.storage.StorageModel
import com.nicname.iyeongjun.dobike.adapter.recycler.model.theme.ThemeModel
import com.nicname.iyeongjun.dobike.adapter.recycler.model.tour.TourModel2
import com.nicname.iyeongjun.gwangju_contest.api.model.weather.WeatherModel
import io.reactivex.subjects.BehaviorSubject

class DataDriver{
    val weatherDriver = BehaviorSubject.create<WeatherModel>()
    val tourDriver = BehaviorSubject.create<TourModel2>()
    val locationDriver = BehaviorSubject.create<LocationModel>()
    val themeDriver = BehaviorSubject.create<ThemeModel>()
    val storageDriver = BehaviorSubject.create<StorageModel>()
}