package com.exam.application.presenter.search

import android.content.Context
import android.util.Log
import com.exam.application.MainActivity
import com.exam.application.R
import com.exam.application.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class SearchPresenter
    : SearchViewPresenter.SearchMethodPresenter {
    var context: Context? = null
    var disposable: Disposable? = null
    var activity: MainActivity? = null
    var parentView: SearchViewPresenter.SearchViewP? = null

    constructor(
        context: Context?,
        activity: MainActivity?,
        parentView: SearchViewPresenter.SearchViewP?
    ) {
        this.context = context
        this.activity = activity
        this.parentView = parentView
    }

    override fun requestSearch(authorization: String, query: String) {
        if (activity!!.checkInternetConnection()) {
            activity!!.showProgressbar()

            disposable = ApiClient.instance.getRequestSearch(authorization, query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    activity!!.hideProgressbar()
                    when (response.code()) {
                        200, 201, 202 -> {
                            parentView!!.onSuccess(response)
                        }

                        401 -> {

                        }

                        402, 422 -> {

                            if (!response.isSuccessful) {
                                response.errorBody()
                                var error: String? = ""
                                try {
                                    val ereader = BufferedReader(
                                        InputStreamReader(
                                            response.errorBody()!!.byteStream()
                                        )
                                    )
                                    var eline: String? = null
                                    while (ereader.readLine().also({ eline = it }) != null) {
                                        error += eline + ""
                                    }
                                    ereader.close()
                                } catch (e: Exception) {
                                    error += e.message
                                }
                                Log.e("Error", error.toString())
                                try {
                                    val reader = JSONObject(error)
                                    val message = reader.getString("message1")
                                    activity?.onError(message)
                                } catch (e: JSONException) {
                                    e.printStackTrace()
                                }
                            }
                        }
                        500 -> {
                            activity!!.onError("Internal Server Error ")
                        }
                        501 -> {
                            activity!!.onError("Internal Server Error ")
                        }

                    }
                }, { error ->
                    activity!!.hideProgressbar()
                    activity!!.onError(error.localizedMessage)
                })
        } else {
            activity!!.toast(context!!.getString(R.string.check_internet_connection))
        }
    }

    override fun stop() {
        if (disposable != null) {
            disposable!!.dispose()
        }
    }
}