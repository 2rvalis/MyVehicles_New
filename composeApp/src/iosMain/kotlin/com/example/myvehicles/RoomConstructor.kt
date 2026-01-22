package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

// Η Room στο iOS χρειάζεται αυτή τη δήλωση για να "δέσει" τον κώδικα
expect fun instantiateImpl(): VehicleDatabase