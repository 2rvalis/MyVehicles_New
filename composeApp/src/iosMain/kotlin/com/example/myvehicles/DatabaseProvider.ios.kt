package com.example.myvehicles

actual fun instantiateDatabase(): VehicleDatabase {
    return VehicleDatabase_Impl()
}