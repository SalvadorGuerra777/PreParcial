package com.guerra.preparcial.data.adapter

import androidx.recyclerview.widget.RecyclerView
import com.guerra.preparcial.data.model.DragonModel
import com.guerra.preparcial.databinding.FragmentDragonItemBinding

class DragonRecyclerViewHolder(private val binding: FragmentDragonItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(dragon : DragonModel, clickListener: (DragonModel) -> Unit){
        binding.textViewName.text = dragon.name
        binding.textViewForce.text = dragon.force

        binding.cardViewDragon.setOnClickListener{
            clickListener(dragon)
        }
    }
}