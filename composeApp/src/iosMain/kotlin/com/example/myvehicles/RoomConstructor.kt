package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

// ΠΡΟΣΟΧΗ: Αφαιρέσαμε το @ConstructedBy από εδώ.
// Υπάρχει ήδη στο commonMain, οπότε εδώ απαγορεύεται.
@Suppress("NO_ACTUAL_FOR_EXPECT")
actual object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    override fun initialize(): VehicleDatabase = instantiateImpl()
}

/**
 * Η Room παράγει αυτή τη συνάρτηση αυτόματα στο iOS.
 * Χρησιμοποιούμε 'expect' (αντί για extern) για να είναι συμβατό με τις νέες εκδόσεις.
 */
expect fun instantiateImpl(): VehicleDatabase