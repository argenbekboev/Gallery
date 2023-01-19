package com.example.gallery

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.gallery.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    class SecondActivity : BaseActivity<ActivitySecondBinding>() {

        private lateinit var adapter : ImageAdapter
        private var images = arrayListOf<ImageModel>()

        override fun inflateViewBinding(inflater: LayoutInflater): ActivitySecondBinding {
            return ActivitySecondBinding.inflate(layoutInflater)
        }

        override fun imageSend() {
            images = intent.getSerializableExtra("key") as ArrayList<ImageModel>
            adapter = ImageAdapter(images, this::OnClick)
            binding.selectedRecycler.adapter = adapter
        }

        private fun OnClick(model : ImageModel) {
        }

        override fun initView() {
        }

        override fun loadImage() {
        }
    }
}