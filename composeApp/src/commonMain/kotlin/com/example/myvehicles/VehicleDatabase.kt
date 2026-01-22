package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Vehicle::class], version = 1)
// ΑΦΑΙΡΟΥΜΕ ΤΟ @ConstructedBy - Δεν θα το χρησιμοποιήσουμε καθόλου
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}