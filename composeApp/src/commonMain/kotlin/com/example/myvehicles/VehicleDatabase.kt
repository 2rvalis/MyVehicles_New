package com.example.myvehicles

import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

expect abstract class VehicleDatabase : RoomDatabase {
    abstract fun vehicleDao(): VehicleDao
}

// Αυτό επιτρέπει στα annotations να "βλέπουν" το όνομα χωρίς conflict
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase>