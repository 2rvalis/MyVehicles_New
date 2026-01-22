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
        // Χρησιμοποιούμε την _Impl κλάση που παράγει η Room αυτόματα στο Android
        factory = { instantiateImpl() }
    )
}

// Δηλώνουμε ότι η Room θα μας δώσει αυτή τη συνάρτηση
expect fun instantiateImpl(): VehicleDatabase