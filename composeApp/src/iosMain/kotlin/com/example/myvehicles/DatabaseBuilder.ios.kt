package com.example.myvehicles

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import androidx.room.ConstructedBy
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

@Database(entities = [Vehicle::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
actual abstract class VehicleDatabase : RoomDatabase() {
    actual abstract fun vehicleDao(): VehicleDao
}

// ΕΔΩ ΔΕΝ ΠΡΕΠΕΙ ΝΑ ΥΠΑΡΧΕΙ ΤΟ actual object AppDatabaseConstructor

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val dbFile = NSHomeDirectory() + "/vehicle_room.db"
    return Room.databaseBuilder<VehicleDatabase>(
        name = dbFile
    ).setDriver(BundledSQLiteDriver())
}