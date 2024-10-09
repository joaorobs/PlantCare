package com.example.plantcare.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [PlantModel::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class PlantDBTwo: RoomDatabase(){

    companion object {
        const val NAME = "Plant_DBTwo"
    }

    abstract fun getPlantDao(): PlantDao
}