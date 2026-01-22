package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ConstructedBy
import androidx.room.RoomDatabaseConstructor

@Database(entities = [Vehicle::class], version = 1)
@ConstructedBy(VehicleDatabaseConstructor::class) // Αλλαγή ονόματος
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

// Χρησιμοποιούμε κλάση αντί για object εδώ
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class VehicleDatabaseConstructor() : RoomDatabaseConstructor<VehicleDatabase>