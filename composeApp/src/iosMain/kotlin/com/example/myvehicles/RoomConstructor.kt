package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
actual class VehicleDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    // Στο iOS η Room καλεί την initialize()
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

// Η συνάρτηση που παράγει η Room αυτόματα
expect fun instantiateImpl(): VehicleDatabase