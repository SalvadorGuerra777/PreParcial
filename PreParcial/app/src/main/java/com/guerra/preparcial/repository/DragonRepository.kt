package com.guerra.preparcial.repository

import com.guerra.preparcial.data.dragons
import com.guerra.preparcial.data.model.DragonModel

class DragonRepository (private  val dragons: MutableList<DragonModel>){
    fun getDragons() = dragons

    fun setDragons (dragon: DragonModel) = dragons.add(dragon)
}