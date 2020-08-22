package com.exam.application

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.exam.application.model.Datum
import com.exam.application.model.SearchDataResponse
import com.exam.application.network.Constants
import com.exam.application.presenter.search.SearchPresenter
import com.exam.application.presenter.search.SearchViewPresenter
import com.exam.application.view.BaseActivity
import com.exam.application.view.ui.SearchListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : BaseActivity(), SearchViewPresenter.SearchViewP {

    var searchView: SearchView? = null

    var searchString: String? = null

    var response : Response<SearchDataResponse>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchview) as SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchString = query
                validateError()
                searchView!!.clearFocus();
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
    }

    override fun validateError() {

        var searchPresenter = SearchPresenter(this@MainActivity, this, this)

        val authorization = Constants.Authorization

        searchPresenter.requestSearch(authorization, searchString.toString())
    }

    override fun onSuccess(reposnseModel: Response<SearchDataResponse>) {

        if (reposnseModel.isSuccessful) {

            if (reposnseModel.body()!!.data!!.isNullOrEmpty()) {
                Toast.makeText(
                    this, "No data found!",
                    Toast.LENGTH_LONG
                ).show()
                text_empty.visibility = View.VISIBLE

            } else {

                response = reposnseModel

                text_empty.visibility = View.GONE
                rv_search_list.visibility = View.VISIBLE

                var adapter = SearchListAdapter(this, reposnseModel.body()!!.data!!)
                rv_search_list.setAdapter(adapter)
                rv_search_list.layoutManager =
                    GridLayoutManager(
                        this, 4
                    )
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (response!=null){
            outState.putParcelableArrayList("response", response!!.body()!!.data)
        }
    }

    /*override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelableArrayList("response", response!!.body()!!.data)

    }*/

   /* override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getParcelableArrayList<Datum>("response")

        var adapter = SearchListAdapter(this, savedInstanceState.getParcelableArrayList<Datum>("response")!!)
        rv_search_list.setAdapter(adapter)

        rv_search_list.layoutManager =
            GridLayoutManager(
                this, 4
            )
    }*/

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState.getParcelableArrayList<Datum>("response")

        text_empty.visibility = View.GONE
        rv_search_list.visibility = View.VISIBLE

        var adapter = SearchListAdapter(this, savedInstanceState.getParcelableArrayList<Datum>("response")!!)
        rv_search_list.setAdapter(adapter)

        rv_search_list.layoutManager =
            GridLayoutManager(
                this, 4
            )
    }

}