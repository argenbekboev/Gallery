package com.example.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.databinding.ItemTaskBinding

class ImageAdapter(var list : ArrayList<ImageModel>,var onClick:((ImageModel) -> Unit)):RecyclerView.Adapter<ImageAdapter.ViewHolder>(){
    inner  class ViewHolder(private var binding : ItemTaskBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model : ImageModel) {
            binding.imageItem.setImageResource(model.image)
            itemView.setOnClickListener {
                onClick(model)
                if (model.select){
                    binding.imageSelect.visibility = View.VISIBLE
                }else{
                    binding.imageSelect.visibility = View.INVISIBLE
                }
            }
            onClick(model)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}
