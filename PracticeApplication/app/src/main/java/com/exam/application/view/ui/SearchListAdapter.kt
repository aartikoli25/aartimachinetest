package com.exam.application.view.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exam.application.R
import com.exam.application.ViewActivity
import com.exam.application.model.Datum


class SearchListAdapter(
    private var context: Context?,
    private var dataList: List<Datum>
) :
    RecyclerView.Adapter<SearchListAdapter.PopularHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.search_item, parent, false)
        return PopularHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: PopularHolder, position: Int) {

        var image = dataList[position].images

        if (image != null) {
            for (i in 0 until image.size) {
                Glide
                    .with(context!!)
                    .load(image.get(i).link)
                    .centerCrop()
                    .into(holder.image_search)

                holder.image_search.setOnClickListener {
                    val intent = Intent(
                        context,
                        ViewActivity::class.java
                    )
                    intent.putExtra("img", image.get(i).link)
                    intent.putExtra("title", dataList[position].title.toString())
                    intent.putExtra("id", image.get(i).id)
                    context?.startActivity(intent)
                }

            }
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class PopularHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image_search = itemView.findViewById(R.id.image_search) as ImageView

    }
}