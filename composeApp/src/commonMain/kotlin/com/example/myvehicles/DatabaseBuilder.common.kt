package com.example.myvehicles

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

// Η "υπόσχεση" που συνδέει Android και iOS
expect fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase>

// Βοηθητική συνάρτηση για να παίρνουμε τη βάση
fun getDatabase(): VehicleDatabase {
    // Στο Android, η getDatabaseBuilder() θα χρησιμοποιήσει τη globalContext
    return getDatabaseBuilder()
        .setDriver(BundledSQLiteDriver())
        .build()
}