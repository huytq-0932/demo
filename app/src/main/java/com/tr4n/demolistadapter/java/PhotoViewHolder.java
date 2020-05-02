package com.tr4n.demolistadapter.java;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tr4n.demolistadapter.R;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    private Photo itemData;
    private TextView textTitle;
    private ImageView imagePhoto;

    public PhotoViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.textTitle);
        imagePhoto = itemView.findViewById(R.id.imagePhoto);

        /**
         * Nếu gán sự kiện onClick trong onBindViewHolder, mỗi lần bind nó sẽ gán lại một lần
         * Thay vì đó, gán trong khởi tạo ViewHolder, khi chỉ khởi tạo lần đầu tiên mới gán.
         */
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(itemData, getAdapterPosition());
                }
            }
        });
    }

    public void bindData(Photo photo) {
        itemData = photo;
        textTitle.setText(photo.getTitle());
        Glide.with(itemView.getContext())
                .load(photo.getUrl()).
                into(imagePhoto);
    }
}
