package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

// Καταργούμε το actual object.
// Αντικαθιστούμε με ένα suppress που επιτρέπει στη Room να κάνει inject τον κώδικα
@Suppress("UNCHECKED_CAST")
fun instantiateImpl(): VehicleDatabase {
    // Αυτό το string είναι το standard όνομα που παράγει η Room εσωτερικά
    val constructorName = "com.example.myvehicles.VehicleDatabase_Instantiator"
    return (null as? RoomDatabaseConstructor<VehicleDatabase>)?.initialize()
        ?: error("Room factor failed to load")
}