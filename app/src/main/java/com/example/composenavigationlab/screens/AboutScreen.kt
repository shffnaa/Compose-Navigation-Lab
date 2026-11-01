package com.example.composenavigationlab.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen(onBack: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        TextButton(onClick = onBack) {
            Text("← Kembali ke Home")
        }

        Text(
            text = "About Application",
            style = MaterialTheme.typography.headlineMedium
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = Modifier.size(88.dp),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "🎓",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Student App",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Student Management Application",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(
                    text = "Version 1.0.0",
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 6.dp
                    ),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        Text(
            text = "About Student App",
            style = MaterialTheme.typography.titleMedium
        )

        Card {
            Text(
                text = "Student App merupakan aplikasi sederhana " +
                        "berbasis Android yang dibuat untuk menampilkan " +
                        "daftar mahasiswa serta informasi detail " +
                        "setiap mahasiswa. Aplikasi ini dikembangkan " +
                        "menggunakan Jetpack Compose.",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Text(
            text = "Application Features",
            style = MaterialTheme.typography.titleMedium
        )

        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AboutFeature(
                    icon = "👥",
                    title = "Student List",
                    description = "Menampilkan daftar mahasiswa."
                )

                AboutFeature(
                    icon = "📋",
                    title = "Student Detail",
                    description = "Menampilkan informasi mahasiswa berdasarkan ID."
                )

                AboutFeature(
                    icon = "👤",
                    title = "Profile",
                    description = "Menampilkan informasi pembuat aplikasi."
                )

                AboutFeature(
                    icon = "🧭",
                    title = "Navigation",
                    description = "Navigasi antarhalaman aplikasi."
                )
            }
        }

        Text(
            text = "Application Information",
            style = MaterialTheme.typography.titleMedium
        )

        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AboutInfo("Application", "Student App")
                AboutInfo("Version", "1.0.0")
                AboutInfo("Platform", "Android")
                AboutInfo("Framework", "Jetpack Compose")
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Developed by Shafa Rizwana Zarin",
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = "Student App • 2026",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun AboutFeature(
    icon: String,
    title: String,
    description: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            style = MaterialTheme.typography.headlineSmall
        )

        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun AboutInfo(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

