package com.ovsyannikov.androidversions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AndroidAdapter(
    Context: Context, private val android: List<Android>,
    private val clickListener: (position: Int) -> Unit
) : RecyclerView.Adapter<AndroidAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(Context)

    class ViewHolder(
        itemView: View,
        listener: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val androidImage: ImageView = itemView.findViewById(R.id.androidImage)
        private val androidText: TextView = itemView.findViewById(R.id.androidText)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener(position)
                }
            }
        }

        fun bind(version: Android) {
            androidImage.setImageResource(version.imageAndroid)
            androidText.text = version.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_android, parent, false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resolveInfo = android[position]
        holder.bind(resolveInfo)
    }

    override fun getItemCount(): Int {
        return android.size
    }
}
