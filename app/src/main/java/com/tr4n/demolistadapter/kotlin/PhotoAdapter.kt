package com.tr4n.demolistadapter.kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tr4n.demolistadapter.R

class PhotoAdapter : RecyclerView.Adapter<PhotoViewHolder>() {

    var onItemClick: (Photo, Int) -> Unit = { _, _ -> }
    private val photos = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(itemView, onItemClick)
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindData(photos[position])
    }

    fun updateData(newPhotos: List<Photo>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }

    fun addData(morePhotos: List<Photo>) {
        val oldSize = itemCount
        photos.addAll(morePhotos)
        val newSize = itemCount
        notifyItemRangeChanged(oldSize, newSize)
    }
}