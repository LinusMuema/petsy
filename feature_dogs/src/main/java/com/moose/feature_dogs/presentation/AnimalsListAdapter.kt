package com.moose.feature_dogs.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.moose.feature_dogs.databinding.ItemBinding

class AnimalsListAdapter(private val images: List<String>): RecyclerView.Adapter<AnimalsListAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    inner class AnimalViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(url: String) {
            binding.image.load(url){
                crossfade(true)
                crossfade(500)
            }
        }

    }
}