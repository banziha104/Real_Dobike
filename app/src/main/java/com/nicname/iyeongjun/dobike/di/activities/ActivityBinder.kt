package com.nicname.iyeongjun.dobike.di.activities

import com.nicname.iyeongjun.dobike.di.activities.module.MainModule
import com.nicname.iyeongjun.dobike.ui.activities.main.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


// 액티비티를 대거 그래프에 올리는 클래스
@Module
abstract class ActivityBinder{

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMain() : MainActivity
}