package com.tr4n.demolistadapter.kotlin

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tr4n.demolistadapter.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val photoListAdapter = PhotoListAdapter()
    private val photoAdapter = PhotoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        recyclerPhotos.adapter = photoListAdapter.apply {
            onItemClick = { item, position ->
                toast("Photo($position) : ${item.title}")
            }
        }
        /*
        Nếu dùng Adapter thông thường
        recyclerPhotos.adapter = photoAdapter.apply {
            onItemClick = { item, position ->
                toast("Photo($position) : ${item.title}")
            }
        }
        */
    }

    private fun initData() {
        val photos = listOf(
            Photo(
                1,
                "Nguyen Van A",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                2,
                "Nguyen Van B",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                3,
                "Nguyen Van C",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                4,
                "Nguyen Van D",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                5,
                "Nguyen Van E",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                6,
                "Nguyen Van F",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                7,
                "Tran Van A",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                8,
                "Tran Van B",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                9,
                "Tran Van C",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                10,
                "Tran Van D",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                11,
                "Tran Van E",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                12,
                "Tran Van F",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            )
        )
        photoListAdapter.submitList(photos)
        /*
            Hoặc
            photoAdapter.updateData(photos)
         */
    }
}

private fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
