package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_downloading_image.*

class DownloadingImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloading_image)

        btnDownload.setOnClickListener {
            val imageDownloadUrl:String="http://192.168.43.61/a2.jpg"
            Picasso.get().load(imageDownloadUrl).into(DownloadedImage)



        }
    }
}