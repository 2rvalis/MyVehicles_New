package com.example.myvehicles

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Αυτή η μεταβλητή αρχικοποιείται στην MainActivity.kt (onCreate)
 * και επιτρέπει στη Room να βρει το path της βάσης δεδομένων στο Android.
 */
lateinit var globalContext: Context

/**
 * Η Android υλοποίηση της expect συνάρτησης που ορίστηκε στο commonMain.
 */
actual fun getDatabaseBuilder(): RoomDatabase.Builder<VehicleDatabase> {
    // Χρησιμοποιούμε το applicationContext για να αποφύγουμε memory leaks
    val appContext = globalContext.applicationContext

    // Καθορίζουμε το path όπου θα αποθηκευτεί το αρχείο της βάσης (.db)
    val dbFile = appContext.getDatabasePath("vehicle_room.db")

    return Room.databaseBuilder<VehicleDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
        factory = { AppDatabaseConstructor.initialize() }
    )
}