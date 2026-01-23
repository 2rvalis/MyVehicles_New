package com.example.myvehicles

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

lateinit var globalContext: Context

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val appContext = globalContext.applicationContext
    return Room.databaseBuilder<VehicleDatabase>(
        context = appContext,
        name = appContext.getDatabasePath("vehicle_room.db").absolutePath
    )
}