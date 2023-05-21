package com.guerra.preparcial.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guerra.preparcial.data.dragons
import com.guerra.preparcial.data.model.DragonModel
import com.guerra.preparcial.databinding.FragmentDragonItemBinding
import java.util.ArrayList


class DragonRecylcerViewAdapter(
    private val clickListener: (DragonModel)-> Unit
): RecyclerView.Adapter<DragonRecyclerViewHolder>() {
    private val dragons = ArrayList<DragonModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonRecyclerViewHolder {
        val binding = FragmentDragonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DragonRecyclerViewHolder(binding)
    }

    override fun getItemCount()= dragons.size

    override fun onBindViewHolder(holder: DragonRecyclerViewHolder, position: Int) {
        val dragon = dragons[position]
        holder.bind(dragon, clickListener)
    }

    fun setData(dragonsList: List<DragonModel>){
        dragons.clear()
        dragons.addAll(dragonsList)
    }

}