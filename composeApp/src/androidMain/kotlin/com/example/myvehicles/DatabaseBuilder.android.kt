package com.example.myvehicles

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

lateinit var globalContext: Context

actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    val appContext = globalContext.applicationContext
    val dbFile = appContext.getDatabasePath("vehicle_room.db")

    return Room.databaseBuilder<VehicleDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    ).setDriver(androidx.sqlite.driver.bundled.BundledSQLiteDriver()) // Προαιρετικό αλλά προτείνεται για συνέπεια
        .setQueryCoroutineContext(kotlinx.coroutines.Dispatchers.IO)
}

// ΔΙΑΓΡΑΨΕ ΤΗΝ ΓΡΑΜΜΗ factory = { ... }
// Στο Android, αν έχεις το @ConstructedBy στην VehicleDatabase,
// η Room βρίσκει ΜΟΝΗ ΤΗΣ τον Constructor, δεν χρειάζεται factory στην alpha10!