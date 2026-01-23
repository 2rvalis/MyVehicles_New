package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ConstructedBy

@Database(entities = [Vehicle::class], version = 1)
// Αφήνουμε το ConstructedBy να δείχνει στην κλάση που θα παράξει η Room αυτόματα
@ConstructedBy(AppDatabaseConstructor::class)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

expect fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase>