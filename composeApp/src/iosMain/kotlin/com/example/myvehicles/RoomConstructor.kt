package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

// Εδώ ΔΕΝ βάζουμε το @ConstructedBy.
// Το KSP το βρίσκει αυτόματα από το commonMain.
@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

/**
 * Αυτή η συνάρτηση παράγεται αυτόματα από τη Room στο iOS build.
 * Τη δηλώνουμε ως 'expect' για να "κουμπώσει" με τον κώδικα της Room.
 */
expect fun instantiateImpl(): VehicleDatabase