package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ConstructedBy
import androidx.room.RoomDatabaseConstructor

@Database(entities = [Vehicle::class], version = 1)
@ConstructedBy(VehicleDatabaseConstructor::class) // Χρήση του interface
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

// Ορίζουμε ένα interface αντί για expect object
expect object VehicleDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase>