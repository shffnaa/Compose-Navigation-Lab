package com.example.composenavigationlab.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.composenavigationlab.ui.detail.DetailUiState

@Composable
fun DetailScreen(uiState: DetailUiState, onBack: () -> Unit) {
    val student = uiState.student

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TextButton(onClick = onBack) {
            Text("← Kembali")
        }

        Text(
            "Student Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        if (student != null) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier
                        .size(88.dp)
                        .clip(CircleShape),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            student.name
                                .split(" ")
                                .take(2)
                                .joinToString("") { it.first().uppercase() },
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    student.name,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    "Mahasiswa Aktif",
                    color = MaterialTheme.colorScheme.secondary
                )

                Text(
                    "Student ID: ${student.id}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                "Personal Information",
                style = MaterialTheme.typography.titleMedium
            )

            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DetailItem("Student ID", student.id.toString())
                    DetailItem("Full Name", student.name)
                    DetailItem("Study Program", student.program)
                    DetailItem("Academic Year", student.year.toString())
                }
            }

            Text(
                "University Information",
                style = MaterialTheme.typography.titleMedium
            )

            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Universitas Brawijaya",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text("Fakultas Ilmu Komputer")
                    Text("Malang, Jawa Timur")
                }
            }

        } else {
            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Student tidak ditemukan",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        uiState.errorMessage
                            ?: "Data mahasiswa tidak tersedia."
                    )
                }
            }
        }

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali ke Home")
        }
    }
}

@Composable
fun DetailItem(label: String, value: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
