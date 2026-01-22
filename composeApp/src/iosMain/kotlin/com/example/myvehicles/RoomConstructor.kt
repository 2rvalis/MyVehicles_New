package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

// Αυτό το expect είναι απαραίτητο για να "κουμπώσει" με το generated code της Room
expect fun instantiateImpl(): VehicleDatabase