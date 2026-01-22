package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object MyDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

/**
 * Η Room παράγει αυτή τη συνάρτηση αυτόματα στο iOS build.
 */
expect fun instantiateImpl(): VehicleDatabase