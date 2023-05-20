package com.guerra.preparcial.ui.dragonball.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guerra.preparcial.DragonReviewerApplication
import com.guerra.preparcial.data.model.DragonModel
import com.guerra.preparcial.repository.DragonRepository

class DragonViewModel (private val repository: DragonRepository): ViewModel() {
    val name = MutableLiveData("")
    val type = MutableLiveData("")
    val description = MutableLiveData("")
    val force = MutableLiveData("")
    val status = MutableLiveData("")

    //logical on back
    private var screenNumber: Int = 0

    fun getScreenFragment()= screenNumber

    fun SetNewDragonFragment () {
        screenNumber = 2
    }

    fun SetDragonFragment() {
        screenNumber = 1
    }
    fun SetDragon_boardFragment() {
        screenNumber = 0
    }

    fun getDragons () = repository.getDragons()

    private fun addDragon (dragon: DragonModel) = repository.setDragons(dragon)

    fun createDragon(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }
        val dragon = DragonModel(
            name.value!!,
            type.value!!,
            description.value!!,
            force.value!!,

            )
        addDragon(dragon)
        clearData()

        status.value = DRAGON_CREATED
    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrBlank() -> return false
            type.value.isNullOrBlank() -> return false
            description.value.isNullOrBlank() -> return false
            force.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearData(){
        name.value = ""
        type.value = ""
        description.value = ""
        force.value = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedDragon(dragon: DragonModel){
        name.value = dragon.name
        type.value = dragon.type
        description.value = dragon.description
        force.value = dragon.force
    }
    companion object{
        val Factory = viewModelFactory {
            initializer {
                val dragonRepositoryApp = (this[APPLICATION_KEY] as DragonReviewerApplication).DragonRepository

                DragonViewModel(dragonRepositoryApp)
            }
        }
        const val DRAGON_CREATED = "POKEMON created"
        const val  WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""

    }
}