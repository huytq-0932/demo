package com.tr4n.demolistadapter.java;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tr4n.demolistadapter.R;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView recyclerPhotos;
    private PhotoAdapter photoAdapter = new PhotoAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        recyclerPhotos = findViewById(R.id.recyclerPhotos);
        photoAdapter.setItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(Photo photo, int position) {
                Toast.makeText(getApplicationContext(), photo.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerPhotos.setAdapter(photoAdapter);
    }

    private void initData() {
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo(
                1,
                "Nguyen Van A",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"));
        photos.add(new Photo(
                1,
                "Nguyen Van A",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"));
        photos.add(new Photo(
                1,
                "Nguyen Van A",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"));
        photos.add(new Photo(
                1,
                "Nguyen Van A",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"));
        photoAdapter.updateData(photos);
    }
}
