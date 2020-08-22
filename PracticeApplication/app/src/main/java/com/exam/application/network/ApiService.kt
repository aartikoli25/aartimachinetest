package com.exam.application.network

import com.exam.application.model.SearchDataResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("search/1")
    fun getSearch(
        @Header("Authorization") authorization: String,
        @Query("q") query: String
    ): Observable<Response<SearchDataResponse>>

}