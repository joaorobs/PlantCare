package com.example.plantcare.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import coil.compose.AsyncImagePainter

@Entity
data class PlantModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val waterFrequency: String,
    val image: Uri?
    )
