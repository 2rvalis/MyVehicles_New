package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ConstructedBy

@Database(entities = [Vehicle::class], version = 1)
@ConstructedBy(IosDatabaseConstructor::class)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}