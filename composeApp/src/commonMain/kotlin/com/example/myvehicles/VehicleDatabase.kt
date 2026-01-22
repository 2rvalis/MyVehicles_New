package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Vehicle::class], version = 1)
// ΟΧΙ @ConstructedBy εδώ. Το αφαιρούμε οριστικά.
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}