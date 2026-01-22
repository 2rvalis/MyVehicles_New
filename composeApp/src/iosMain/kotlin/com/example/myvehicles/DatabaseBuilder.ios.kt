package com.example.myvehicles

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val dbFile = NSHomeDirectory() + "/vehicle_room.db"
    return Room.databaseBuilder<VehicleDatabase>(
        name = dbFile,
        factory = { instantiateImpl() } // Χρησιμοποιούμε την εσωτερική συνάρτηση
    ).setDriver(BundledSQLiteDriver())
}

// Αυτό το expect θα συνδεθεί με το generated code της Room στο iOS
expect fun instantiateImpl(): VehicleDatabase