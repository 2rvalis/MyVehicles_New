package com.example.myvehicles

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val dbFile = NSHomeDirectory() + "/vehicle_room.db"
    return Room.databaseBuilder<VehicleDatabase>(
        name = dbFile
        // ΠΡΟΣΟΧΗ: ΚΑΝΕΝΑ factory εδώ. Η Room θα βρει μόνη της τον Constructor που παρήγαγε.
    ).setDriver(BundledSQLiteDriver())
}