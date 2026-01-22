package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ConstructedBy
import androidx.room.RoomDatabaseConstructor

@Database(entities = [Vehicle::class], version = 1)
@ConstructedBy(MyDatabaseConstructor::class)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

// Εδώ πρέπει να είναι το expect
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object MyDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase>