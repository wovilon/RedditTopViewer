package com.example.reddittopviewer.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reddittopviewer.R
import com.example.reddittopviewer.model.Publication
import kotlinx.android.synthetic.main.top_item.view.*

class TopAdapter(val data: ArrayList<Publication>, val context: Context) :
    RecyclerView.Adapter<TopAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.top_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TopAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.name.text = item.author
        holder.timeAgo.text = prepareTimeAgo(item.timeAgo)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.tvName
        val image = itemView.ivThumbnail
        val timeAgo = itemView.tvTimeAgo
        val comments = itemView.tvCommentsNumber

    }

    private fun prepareTimeAgo(hours: Int): String{
        val lastDigit = hours % 10


        if (lastDigit == 1) return "$hours ${context.resources.getString(R.string.hour)}${context.resources.getString(R.string.s)} ${context.resources.getString(R.string.ago)}"
        else return "$hours ${context.resources.getString(R.string.hour)}${context.resources.getString(R.string.s)} ${context.resources.getString(R.string.ago)}"
    }
}