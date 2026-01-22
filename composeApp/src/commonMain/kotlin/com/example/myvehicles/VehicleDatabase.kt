package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ConstructedBy
import androidx.room.RoomDatabaseConstructor

@Database(entities = [Vehicle::class], version = 1)
// Χρησιμοποιούμε ένα interface/class που θα γίνει actual στην κάθε πλευρά
@ConstructedBy(AppDatabaseConstructor::class)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

// Δηλώνουμε τον constructor ως expect class αντί για object
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class AppDatabaseConstructor() : RoomDatabaseConstructor<VehicleDatabase>