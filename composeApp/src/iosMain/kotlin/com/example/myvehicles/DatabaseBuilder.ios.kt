package com.example.myvehicles

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val dbFile = NSHomeDirectory() + "/vehicle_room.db"
    // Η Room θα βρει αυτόματα τον VehicleDatabaseConstructor λόγω του @ConstructedBy
    return Room.databaseBuilder<VehicleDatabase>(
        name = dbFile,
        factory = { instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
}