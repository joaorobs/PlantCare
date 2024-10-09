package com.example.plantcare.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.plantcare.MainApplication
import com.example.plantcare.data.PlantModel

class PlantViewModel : ViewModel() {

    private val plantDao = MainApplication.plantDBTwo.getPlantDao()
    val plantList: LiveData<List<PlantModel>> = plantDao.getPlants()

    suspend fun addPlant(plantModel: PlantModel) {
        plantDao.upsertPlant(
            plantModel = PlantModel(
                name = plantModel.name,
                waterFrequency = plantModel.waterFrequency,
                image = plantModel.image
            )
        )
    }

    suspend fun deletePlant(id : Int) {
        plantDao.deletePlant(
            id
        )
    }

}