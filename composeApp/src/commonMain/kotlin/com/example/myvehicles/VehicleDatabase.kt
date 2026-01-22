package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Vehicle::class], version = 1)
// Το @ConstructedBy αφαιρέθηκε πλήρως για να μην "χτυπάει" το KSP
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

// ΕΔΩ ΔΕΝ ΥΠΑΡΧΕΙ ΠΛΕΟΝ ΤΟ expect object AppDatabaseConstructor