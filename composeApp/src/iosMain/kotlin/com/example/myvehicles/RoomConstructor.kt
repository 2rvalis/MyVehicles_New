package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

// Δηλώνουμε το expect ΕΔΩ (μόνο για το iOS)
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase>

// Υλοποιούμε το actual αμέσως μετά
@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

expect fun instantiateImpl(): VehicleDatabase