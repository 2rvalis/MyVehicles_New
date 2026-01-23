package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ConstructedBy
import androidx.room.RoomDatabaseConstructor

@Database(entities = [Vehicle::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

// Προσοχή: Το όνομα AppDatabaseConstructor πρέπει να είναι ομοιόμορφο παντού
expect object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase>

expect fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase>