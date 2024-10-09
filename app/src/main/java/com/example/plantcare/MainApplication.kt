package com.example.plantcare

import android.app.Application
import androidx.room.Room
import com.example.plantcare.data.PlantDBTwo

class MainApplication : Application() {

    companion object {
        lateinit var plantDBTwo: PlantDBTwo
    }

    override fun onCreate() {
        super.onCreate()
        plantDBTwo = Room.databaseBuilder(
            applicationContext,
            PlantDBTwo::class.java,
            PlantDBTwo.NAME
        ).build()
    }

}