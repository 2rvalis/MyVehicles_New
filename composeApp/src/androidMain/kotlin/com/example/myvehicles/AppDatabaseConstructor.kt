package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

// Δηλώνουμε το expect εδώ για το Android
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase>

// Στο Android δεν χρειάζεται actual object, το παράγει η Room μόνο της.