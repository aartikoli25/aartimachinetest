package com.exam.application.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchDataResponse {
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

    @SerializedName("success")
    @Expose
    var success : Boolean? = null

    @SerializedName("status")
    @Expose
    var status : Long? = null
}