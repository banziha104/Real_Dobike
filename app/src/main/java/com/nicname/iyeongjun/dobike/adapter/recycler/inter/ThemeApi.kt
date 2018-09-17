package com.nicname.iyeongjun.dobike.adapter.recycler.inter

import com.nicname.iyeongjun.dobike.adapter.recycler.model.theme.ThemeModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ThemeApi{
    @GET("theme/")
    fun getTheme(

    ): Observable<ThemeModel>
}