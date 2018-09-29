package com.nicname.iyeongjun.dobike.ui.fragments.ride

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nicname.iyeongjun.dobike.R
import com.nicname.iyeongjun.dobike.realm.model.RideLocalModel
import com.nicname.iyeongjun.dobike.ui.activities.main.splash.realm
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_ride.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class RideFragment : DaggerFragment(), AnkoLogger {

    @Inject
    lateinit var viewModelFactory: RideViewModelFactory
    lateinit var viewModel : RideViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this, viewModelFactory)[RideViewModel::class.java]


        return inflater.inflate(R.layout.fragment_ride, container, false)
    }

    override fun onResume() {
        super.onResume()
        realm.addChangeListener {

        }
        btnRide.setOnClickListener {
//            realm.deleteAll()
//            realm.beginTransaction()
//            var temp = realm.createObject(RideLocalModel::class.java)
//
//            temp.distance = 0.1
//            temp.endLat = 0.2
//            temp.endLon = 0.3
//            temp.endName = "end"
//            temp.startLat = 0.4
//            temp.startLon = 0.5
//            temp.startName = "dd"
//            temp.time = "1초"
//
//            realm.commitTransaction()

            var temp2 = realm.where(RideLocalModel::class.java)
                    .findAll()

            realm.executeTransaction {
                temp2.deleteAllFromRealm()
            }
//
        }

    }
}
