package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

/**
 * Η Room παράγει αυτή τη συνάρτηση αυτόματα στο iOS.
 * Τη δηλώνουμε ως extern για να τη βρει ο linker.
 */
extern fun instantiateImpl(): VehicleDatabase