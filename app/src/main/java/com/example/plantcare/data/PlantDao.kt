package com.example.plantcare.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {

    @Upsert
    suspend fun upsertPlant(plantModel: PlantModel)

    @Query("DELETE FROM PlantModel WHERE id = :id")
    suspend fun deletePlant(id : Int)

    @Query("SELECT * FROM PlantModel")
    fun getPlants() : LiveData<List<PlantModel>>
//    fun getPlants() : <List<PlantModel>

}