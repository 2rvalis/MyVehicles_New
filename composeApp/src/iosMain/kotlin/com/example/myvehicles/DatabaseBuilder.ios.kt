package com.example.myvehicles

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val dbFile = NSHomeDirectory() + "/vehicle_room.db"
    return Room.databaseBuilder<VehicleDatabase>(
        name = dbFile,
        factory = { instantiateImpl() } // Εδώ γίνεται η "μαγεία"
    ).setDriver(BundledSQLiteDriver())
}

// Δηλώνουμε την expect συνάρτηση εδώ, μέσα στο iosMain
// Η Room θα την υλοποιήσει αυτόματα κατά το build του iOS
expect fun instantiateImpl(): VehicleDatabase