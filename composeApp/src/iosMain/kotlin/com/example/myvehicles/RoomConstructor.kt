package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

/**
 * Η Room παράγει αυτή τη συνάρτηση αυτόματα στο iOS.
 * Τη δηλώνουμε ως 'expect' (αντί για extern) για να είναι συμβατή με το KSP της Room 2.7.0.
 */
expect fun instantiateImpl(): VehicleDatabase