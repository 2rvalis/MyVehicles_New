package com.example.myvehicles

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

// ΠΡΟΣΘΕΣΕ ΤΟ @Suppress. Είναι απαραίτητο για να μην χτυπάει το KSP της Room στο iOS
@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase>

fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val dbFile = NSHomeDirectory() + "/vehicle_room.db"
    return Room.databaseBuilder<VehicleDatabase>(
        name = dbFile,
        factory = { AppDatabaseConstructor.initialize() }
    ).setDriver(BundledSQLiteDriver()) // Απαραίτητο για το native build
}