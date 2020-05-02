package com.tr4n.demolistadapter.kotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_photo.view.*

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
