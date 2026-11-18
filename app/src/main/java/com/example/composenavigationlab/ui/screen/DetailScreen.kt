package com.example.composenavigationlab.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composenavigationlab.ui.detail.DetailUiState

@Composable
fun DetailScreen(
    uiState: DetailUiState,
    onBack: () -> Unit,
    onToggleFavorite: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF0FAF4)).padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Detail Student", color = Color(0xFF5B9072))
        Spacer(modifier = Modifier.height(16.dp))

        when {
            uiState.isLoading -> CircularProgressIndicator()

            uiState.errorMessage != null -> {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Data mahasiswa tidak dapat ditampilkan")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(uiState.errorMessage)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = onBack,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF82B99A))
                        ) {
                            Text("Kembali ke Home", color = Color.White)
                        }
                    }
                }
            }

            uiState.student != null -> {
                val student = uiState.student

                Text("ID: ${student.id}")
                Text("Nama: ${student.name}")
                Text("Email: ${student.email}")
                Text("University: ${student.university}")

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onToggleFavorite,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF82B99A)
                    )
                ) {
                    Text(
                        if (uiState.isFavorite)
                            "Hapus dari Favorit"
                        else
                            "Simpan ke Favorit",
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF82B99A)
                    )
                ) {
                    Text("Kembali", color = Color.White)
                }
            }
        }
    }
}
