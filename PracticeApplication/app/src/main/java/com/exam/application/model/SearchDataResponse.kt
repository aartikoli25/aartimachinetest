package com.exam.application.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchDataResponse() : Parcelable{
    @SerializedName("data")
    @Expose
    var data: ArrayList<Datum>? = null

    @SerializedName("success")
    @Expose
    var success : Boolean? = null

    @SerializedName("status")
    @Expose
    var status : Long? = null

    constructor(parcel: Parcel) : this() {
        success = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        status = parcel.readValue(Long::class.java.classLoader) as? Long
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(success)
        parcel.writeValue(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchDataResponse> {
        override fun createFromParcel(parcel: Parcel): SearchDataResponse {
            return SearchDataResponse(parcel)
        }

        override fun newArray(size: Int): Array<SearchDataResponse?> {
            return arrayOfNulls(size)
        }
    }
}