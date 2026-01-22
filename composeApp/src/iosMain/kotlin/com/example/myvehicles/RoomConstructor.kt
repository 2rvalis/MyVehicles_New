package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object VehicleDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

// Η συνάρτηση που παράγει η Room
expect fun instantiateImpl(): VehicleDatabase