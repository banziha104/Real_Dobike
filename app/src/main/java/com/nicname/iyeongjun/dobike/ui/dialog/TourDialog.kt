package com.nicname.iyeongjun.dobike.ui.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import com.nicname.iyeongjun.dobike.GlideApp
import com.nicname.iyeongjun.dobike.R
import com.nicname.iyeongjun.dobike.api.model.tour.TourModel2
import com.nicname.iyeongjun.dobike.ar.ARActivity
import com.nicname.iyeongjun.dobike.ar.AROverlayView
import com.nicname.iyeongjun.dobike.ar.model.ARPoint
import com.nicname.iyeongjun.dobike.driver.ArData
import com.nicname.iyeongjun.gwangju_contest.extension.convertType
import com.nicname.iyeongjun.gwangju_contest.extension.getTourToDate
import com.nicname.iyeongjun.nanumcar.util.KakaoNavi
import kotlinx.android.synthetic.main.dialog_tour.*
import org.jetbrains.anko.startActivity

class TourDialog(var activity: Activity?, val item: TourModel2.BodyBean.ItemBean) : Dialog(activity), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_tour)
        txtDiaTourCreated.text = "${item.createdtime.getTourToDate()}"
        txtDiaTourUpdate.text = "${item.modifiedtime.getTourToDate()}"
        txtDiaTourLocation.text = "${item.addr1}"
        txtDiaTourType.text = "${item.contenttypeid.convertType()}"
        txtDiaTourTitle.text = item.title
        txtDiaTourTel.text = item.tel ?: "전화번호없음"

        imgDiaTour.setColorFilter(Color.argb(100, 0, 0, 0))

        if (item.firstimage != null && item.firstimage != "") {
            GlideApp
                    .with(context)
                    .load(item.firstimage)
                    .into(imgDiaTour)
        } else {
            GlideApp
                    .with(context)
                    .load(R.drawable.default_tour_img)
                    .into(imgDiaTour)
        }


        btnDiaTourNavi.setOnClickListener {
            KakaoNavi.startNavi(
                    item.mapy.toDouble(),
                    item.mapx.toDouble(),
                    item.title,
                    activity!!
            )
        }

        btnDiaTour.setOnClickListener {
            AROverlayView.tempAR = ARPoint(item.title,item.mapy.toDouble(),item.mapx.toDouble(),0.0)
            context.startActivity<ARActivity>()
        }
    }

    override fun onClick(v: View) {
        dismiss()
    }
}