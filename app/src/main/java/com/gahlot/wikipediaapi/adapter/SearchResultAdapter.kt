package com.gahlot.wikipediaapi.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gahlot.wikipediaapi.R
import com.gahlot.wikipediaapi.data.Page
import kotlinx.android.synthetic.main.rv_search_child.view.*

class SearchResultAdapter( private val context: Context) :
    RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    private var list : List<Page> = ArrayList()

    fun setLocationList(list: List<Page>){
        this.list = list
        notifyDataSetChanged()
    }

    fun resetList() {
        list = emptyList()
        notifyDataSetChanged()
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val parentHolder = v.rv_main_frame
        val personImage = v.rv_result_image!!
        val personName = v.rv_result_name!!
        val description = v.rv_result_des!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rv_search_child,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (list[position].thumbnail!=null) {
            Glide.with(context).load(list[position].thumbnail.source).into(holder.personImage)
        } else {
            Glide.with(context).load(R.drawable.place_holder).into(holder.personImage)
        }

        holder.personName.text = list[position].title
        if (list.get(position).terms != null) {
            if (list.get(position).terms.description != null) {
                holder.description.text = list[position].terms.description[0]
            } else {
                holder.description.text = "Unavailable"
            }
        } else {
            holder.description.text = "Unavailable"
        }

            holder.parentHolder.setOnClickListener {
                val uri: Uri = Uri.parse(list[position].fullurl)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }
    }
}