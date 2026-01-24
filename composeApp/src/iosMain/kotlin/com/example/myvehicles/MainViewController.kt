package com.example.myvehicles

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    // Καλούμε την κοινή συνάρτηση που φτιάξαμε στο VehicleDatabase.kt
    val database = getDatabase()
    val repository = VehicleRepository(database.vehicleDao())
    val viewModelFactory = VehicleViewModel.factory(repository)

    App(viewModelFactory = viewModelFactory)
}