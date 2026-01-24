package com.example.myvehicles

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

// ΤΟ actual object AppDatabaseConstructor ΠΑΡΑΓΕΤΑΙ ΑΥΤΟΜΑΤΑ ΑΠΟ ΤΗ ROOM - ΜΗΝ ΤΟ ΓΡΑΦΕΙΣ

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val dbFile = NSHomeDirectory() + "/vehicle_room.db"
    return Room.databaseBuilder<VehicleDatabase>(
        name = dbFile
    )
}