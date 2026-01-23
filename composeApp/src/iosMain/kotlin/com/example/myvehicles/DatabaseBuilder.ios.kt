package com.example.myvehicles

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual fun getDatabaseFactory(): () -> VehicleDatabase = {
    VehicleDatabase_Impl()
}

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val dbFile = NSHomeDirectory() + "/vehicle_room.db"
    return Room.databaseBuilder<VehicleDatabase>(
        name = dbFile,
        factory = getDatabaseFactory()
    ).setDriver(BundledSQLiteDriver())
}