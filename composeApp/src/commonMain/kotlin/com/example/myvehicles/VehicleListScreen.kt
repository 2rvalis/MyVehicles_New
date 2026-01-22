package com.example.myvehicles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VehicleListScreen(
    vehicles: List<Vehicle>,
    onVehicleClick: (Long) -> Unit,
    onDeleteVehicle: (Vehicle) -> Unit,
    onAddVehicle: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Τα Οχήματά μου") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddVehicle) {
                Icon(Icons.Default.Add, contentDescription = "Προσθήκη")
            }
        }
    ) { padding ->
        // Προσθήκη verticalScroll για να μπορείς να σκρολάρεις αν έχεις πολλά οχήματα
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            vehicles.forEach { vehicle ->
                VehicleItem(
                    vehicle = vehicle,
                    onClick = { onVehicleClick(vehicle.id) },
                    onDeleteClick = {
                        // ΠΡΙΝ τη διαγραφή από τη βάση, καθαρίζουμε τη μνήμη της συσκευής
                        FileHelper.deleteFile(vehicle.imagePath)
                        FileHelper.deleteFile(vehicle.licensePlatePath)
                        FileHelper.deleteFile(vehicle.registrationPath)
                        FileHelper.deleteFile(vehicle.insurancePath)

                        // Μετά καλούμε τη διαγραφή από τη βάση δεδομένων
                        onDeleteVehicle(vehicle)
                    }
                )
            }
        }
    }
}

@Composable
fun VehicleItem(vehicle: Vehicle, onClick: () -> Unit, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Προεπισκόπηση εικόνας οχήματος
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                if (!vehicle.imagePath.isNullOrEmpty()) {
                    AsyncImage(
                        model = vehicle.imagePath,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(
                        Icons.Default.DirectionsCar,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Στοιχεία οχήματος
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = vehicle.brand,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = vehicle.model,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }

            // Κουμπί Διαγραφής
            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Διαγραφή",
                    tint = Color.Red
                )
            }
        }
    }
}