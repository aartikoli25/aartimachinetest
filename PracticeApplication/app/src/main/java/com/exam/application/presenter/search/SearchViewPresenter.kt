package com.exam.application.presenter.search

import com.exam.application.model.SearchDataResponse
import retrofit2.Response

interface SearchViewPresenter {
    interface SearchViewP {
        fun validateError()
        fun onSuccess(reposnseModel: Response<SearchDataResponse>)
    }

    interface SearchMethodPresenter {
        fun requestSearch(authorization: String, query: String)
        fun stop()
    }
}