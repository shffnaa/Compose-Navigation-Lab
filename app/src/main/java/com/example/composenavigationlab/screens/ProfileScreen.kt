package com.example.composenavigationlab.screens

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

@Composable
fun ProfileScreen(onBack: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        // Header
        TextButton(onClick = onBack) {
            Text("← Kembali ke Home")
        }

        Text(
            text = "My Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        // Profile Header
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "SZ",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "SHAFA RIZWANA ZARIN",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "Mahasiswa Teknik Informatika",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = CircleShape
            ) {
                Text(
                    text = "Mahasiswa Aktif",
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 6.dp
                    ),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        // Personal Information
        Text(
            text = "Personal Information",
            style = MaterialTheme.typography.titleMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ProfileItem(
                    label = "Full Name",
                    value = "SHAFA RIZWANA ZARIN"
                )

                ProfileItem(
                    label = "Student ID",
                    value = "245150207111071"
                )

                ProfileItem(
                    label = "Study Program",
                    value = "Teknik Informatika"
                )

                ProfileItem(
                    label = "Academic Year",
                    value = "2024"
                )
            }
        }

        // University Information
        Text(
            text = "University Information",
            style = MaterialTheme.typography.titleMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "🎓",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Text(
                        text = "Universitas Brawijaya",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                ProfileItem(
                    label = "Faculty",
                    value = "Fakultas Ilmu Komputer"
                )

                ProfileItem(
                    label = "Location",
                    value = "Malang, Jawa Timur"
                )
            }
        }

        // Footer
        Text(
            text = "Student App • Version 1.0.0",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun ProfileItem(
    label: String,
    value: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
