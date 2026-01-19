package com.example.myvehicles

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<VehicleDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("vehicle_room.db")
    return Room.databaseBuilder<VehicleDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
        factory = { VehicleDatabase::class.instantiateImpl() }
    )
}