package com.guerra.preparcial.repository

import com.guerra.preparcial.data.fighters
import com.guerra.preparcial.data.model.DragonModel

class DragonRepository (private  val fighters: MutableList<DragonModel>){
    fun getFighters() = fighters

    fun setFighters (fighter: DragonModel) = fighters.add(fighter)
}