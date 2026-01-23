package com.example.myvehicles

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import androidx.room.ConstructedBy

lateinit var globalContext: Context

@Database(entities = [Vehicle::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
actual abstract class VehicleDatabase : RoomDatabase() {
    actual abstract fun vehicleDao(): VehicleDao
}

// ΕΔΩ ΔΕΝ ΠΡΕΠΕΙ ΝΑ ΥΠΑΡΧΕΙ ΤΟ actual object AppDatabaseConstructor

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val appContext = globalContext.applicationContext
    return Room.databaseBuilder<VehicleDatabase>(
        context = appContext,
        name = appContext.getDatabasePath("vehicle_room.db").absolutePath
    )
}