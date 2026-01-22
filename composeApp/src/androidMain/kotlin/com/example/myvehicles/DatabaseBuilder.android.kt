package com.example.myvehicles

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

lateinit var globalContext: Context

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val appContext = globalContext.applicationContext
    val dbFile = appContext.getDatabasePath("vehicle_room.db")

    return Room.databaseBuilder<VehicleDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
        factory = { AppDatabaseConstructor().initialize() }
    )
}
// ΤΙΠΟΤΑ ΑΛΛΟ ΕΔΩ. Το actual object το φτιάχνει το KSP μόνο του.