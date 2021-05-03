package com.xxpffxx.lab5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xxpffxx.lab5.data.Android

class AndroidAdapter(
    Context: Context, private val android: List<Android>, val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<AndroidAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(Context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_android, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickListener)
    }

    override fun getItemCount(): Int = android.size

    private fun getItem(position : Int) : Android = android[position]


    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val title: TextView = itemView.findViewById(R.id.title)

        fun bind(version : Android, clickListener: OnItemClickListener){
            image.setImageResource(version.imageAndroid)
            title.text = version.title
            itemView.setOnClickListener {
                clickListener.onItemClicked(version)
            }
        }
    }
}

interface OnItemClickListener{
    fun onItemClicked(android : Android)
}