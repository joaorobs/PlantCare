package com.example.plantcare.data

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun uriToString(value: Uri?) : String? {
        return value?.toString()
    }

    @TypeConverter
    fun stringToUri(value : String?) : Uri? {
        return Uri.parse(value)
    }
}