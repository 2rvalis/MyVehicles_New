package com.example.myvehicles

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

lateinit var globalContext: Context

// ΤΟ actual object AppDatabaseConstructor ΠΑΡΑΓΕΤΑΙ ΑΥΤΟΜΑΤΑ ΑΠΟ ΤΗ ROOM - ΜΗΝ ΤΟ ΓΡΑΦΕΙΣ

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val appContext = globalContext.applicationContext
    val dbFile = appContext.getDatabasePath("vehicle_room.db")
    return Room.databaseBuilder<VehicleDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}