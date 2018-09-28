package com.nicname.iyeongjun.dobike.ui.fragments.storage


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.nicname.iyeongjun.dobike.R
import com.nicname.iyeongjun.dobike.api.model.storage.StorageModel
import com.nicname.iyeongjun.dobike.const.sections
import com.nicname.iyeongjun.dobike.ui.activities.main.main.tempLocation
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import javax.inject.Inject


class StorageFragment : DaggerFragment(), OnMapReadyCallback, AnkoLogger {
    @Inject
    lateinit var viewModelFactory: StorageViewModelFactory
    lateinit var viewModel : StorageViewModel
    var mapView: MapView? = null
    var storageModel : StorageModel? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_storage, container, false)
        mapView = view.findViewById(R.id.mapView)
        mapView?.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[StorageViewModel::class.java]
        return view
    }
    override fun onResume() {
        super.onResume()
        mapView?.onResume()
        viewModel
                .driver
                .storageDriver
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    storageModel = it
                    mapView?.getMapAsync(this)
                }
    }


    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onMapReady(map: GoogleMap?) {
        if(tempLocation[0] != null && tempLocation[1] != null){
            info { tempLocation }
            val location = LatLng(tempLocation[0], tempLocation[1])
            map?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.5f))
        }else{
            activity!!.toast("GPS를 확인할수 없습니다 기본인 강남구로 세팅됩니다.")
            val temp = sections.items.filter { it.section == "강남구" }.first()// 강남구 주소로 초기세팅
            val location = LatLng(temp.lat.toDouble(), temp.long.toDouble())
            map?.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.5f))
        }
        for (i in storageModel?.results!!) {
            try {
                val tempLocation = LatLng(i.lat, i.lon)
                val maker = MarkerOptions()
                        .position(tempLocation)
                        .snippet(i.location)
                        .title(i.title)
                map?.addMarker(maker)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
