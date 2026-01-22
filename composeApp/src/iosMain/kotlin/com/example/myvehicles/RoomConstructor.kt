package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object IosDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

// Αυτή η συνάρτηση είναι απαραίτητη για το factory του Builder
expect fun instantiateImpl(): VehicleDatabase