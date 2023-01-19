package com.example.gallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    class MainActivity : AppCompatActivity() {

        private val list = arrayListOf<ImageModel>()
        private val listSelect = arrayListOf<ImageModel>()
        private lateinit var adapter: ImageAdapter
        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            loadImage()
            initView()
            imageSend()
        }

        fun imageSend() {
            list.add(ImageModel(R.drawable.img, true))
            list.add(ImageModel(R.drawable.img_1, true))
            list.add(ImageModel(R.drawable.img_2, true))
            list.add(ImageModel(R.drawable.img_2, true))
            list.add(ImageModel(R.drawable.img_1, true))
            list.add(ImageModel(R.drawable.img, true))
            list.add(ImageModel(R.drawable.img, true))
            list.add(ImageModel(R.drawable.img_1, true))
            list.add(ImageModel(R.drawable.img_2, true))
            list.add(ImageModel(R.drawable.img_2, true))
            list.add(ImageModel(R.drawable.img_1, true))
            list.add(ImageModel(R.drawable.img, true))
        }

        private fun initView() {

            adapter = ImageAdapter(list, this::onClick)
            binding.recyclerview.adapter = adapter
        }

        private fun onClick(imageModel : ImageModel) {
            imageModel.select = !imageModel.select
            if (imageModel.select) {
                listSelect.add(imageModel)
            } else {
                listSelect.remove(imageModel)
            }
        }

        fun loadImage() {
            binding.btnSend.setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("key", listSelect)
                startActivity(intent)
            }
        }
    }
}