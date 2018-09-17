package com.nicname.iyeongjun.dobike.adapter.recycler.model.storage

import com.google.gson.annotations.SerializedName

data class StorageModel(
        @SerializedName("count") val count: Int,
        @SerializedName("next") val next: String,
        @SerializedName("previous") val previous: Any?,
        @SerializedName("results") val results: List<Result>
)