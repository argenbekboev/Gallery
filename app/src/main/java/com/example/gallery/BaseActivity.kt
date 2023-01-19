package com.example.gallery

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)
        imageSend()
        initView()
        loadImage()
    }

    abstract fun imageSend()

    abstract fun initView()

    abstract fun loadImage()
}