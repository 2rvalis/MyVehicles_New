package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

// ΜΟΝΟ ΑΥΤΑ. Τίποτα άλλο.
@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object MyDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

expect fun instantiateImpl(): VehicleDatabase