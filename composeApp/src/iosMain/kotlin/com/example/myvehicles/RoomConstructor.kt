package com.example.myvehicles

import androidx.room.RoomDatabaseConstructor

// Αφαίρεσε το "actual" και το "expect" annotation
@Suppress("NO_ACTUAL_FOR_EXPECT")
object AppDatabaseConstructor : RoomDatabaseConstructor<VehicleDatabase> {
    // Στην alpha10 το αφήνουμε κενό
}