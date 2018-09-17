package com.nicname.iyeongjun.dobike.ui.main.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.nicname.iyeongjun.dobike.R
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import com.nicname.iyeongjun.gwangju_contest.rx.AutoClearedDisposable
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() , AnkoLogger{

    @Inject lateinit var viewModelFactory: MainViewModelFactory //메인 뷰모델 팩토리
    lateinit var viewModel : MainViewModel
    val disposable = AutoClearedDisposable(this) // 자동삭제 -> 라이플사이클 오너
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false) // 라이플사이클과 싱크 맞춤


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

        disposable += viewModel.tourApi.getTourData().subscribe {
            info { it }
        }

        disposable += viewModel.weatherApi.getWeather("37.460667","126.902726").subscribe {
            info { it }
        }

        disposable += viewModel.locationApi.getLocation().subscribe {
            info { it }
        }

        disposable += viewModel.themeApi.getTheme().subscribe{
            info { it }
        }

        disposable += viewModel.storageApi.getStorage("용산구").subscribe {
            info { it }
        }
    }
}
