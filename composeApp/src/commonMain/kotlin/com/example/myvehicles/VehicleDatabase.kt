package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Vehicle::class], version = 1)

abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

// Ορίζουμε μια συνάρτηση που θα υλοποιηθεί σε κάθε πλατφόρμα
expect fun getDatabaseFactory(): () -> VehicleDatabase