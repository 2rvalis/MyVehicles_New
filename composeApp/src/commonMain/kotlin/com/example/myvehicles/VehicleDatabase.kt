package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ConstructedBy
import androidx.room.RoomDatabaseConstructor // Πρόσθεσε αυτό το import

@Database(entities = [Vehicle::class], version = 1)
// ΑΛΛΑΓΗ ΕΔΩ: Χρησιμοποιούμε νέο όνομα που δεν έχει χρησιμοποιηθεί ποτέ
@ConstructedBy(VehicleDatabaseConstructor::class)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
}

// ΠΡΟΣΘΕΣΕ ΑΥΤΕΣ ΤΙΣ ΓΡΑΜΜΕΣ ΣΤΟ ΤΕΛΟΣ ΤΟΥ ΑΡΧΕΙΟΥ
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object VehicleDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase>