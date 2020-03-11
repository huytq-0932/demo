package com.tr4n.demolistadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter : ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(PhotoDiffUtilCallback()) {

    var onItemClick: (Photo, Int) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class PhotoViewHolder(
        itemView: View,
        onItemClick: (Photo, Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private var itemData: Photo? = null

        init {
            /**
             * Nếu gán sự kiện onClick trong onBindViewHolder, mỗi lần bind nó sẽ gán lại một lần
             * Thay vì đó, gán trong khởi tạo ViewHolder, khi chỉ khởi tạo lần đầu tiên mới gán.
             */
            itemView.setOnClickListener {
                itemData?.let {
                    onItemClick(it, adapterPosition)
                }
            }
        }

        fun bindData(photo: Photo) {
            itemData = photo
            itemView.run {
                textTitle.text = photo.title
                Glide.with(context).load(photo.url).into(imagePhoto)
            }
        }
    }

    class PhotoDiffUtilCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem == newItem
    }
}
