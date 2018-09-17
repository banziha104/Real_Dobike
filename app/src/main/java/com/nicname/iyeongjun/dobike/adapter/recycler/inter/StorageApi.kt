package com.nicname.iyeongjun.dobike.adapter.recycler.inter

import com.nicname.iyeongjun.dobike.adapter.recycler.model.storage.StorageModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


// 따릉이 저장소 Api
interface StorageApi{
    @GET("storage/getList")
    fun getStorage(
            @Query("section") section : String
    ): Observable<StorageModel>
}