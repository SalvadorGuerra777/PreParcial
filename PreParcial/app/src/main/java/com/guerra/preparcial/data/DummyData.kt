package com.guerra.preparcial.data


import com.guerra.preparcial.data.model.DragonModel

//model 01
const val name = "Bulbasur"
const val type = "Grass"
const val description = "Un pokemon que nadie elije"
const val force = "1"

//model 02
const val name2 = "Pikachu"
const val type2 = "Electric"
const val description2 = "Un pokemon bien genial."
const val force2 = "25"

var fighters = mutableListOf(
    DragonModel(name, type, description, force),
    DragonModel(name2, type, description2, force2),
)