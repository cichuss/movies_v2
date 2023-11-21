package com.example.movies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies.R

@Composable
fun DescriptionScreen(movieId: Int, navController: NavController) {
    // Get movie details based on movieId
    val movie = getSampleMovies().find { it.id == movieId }

    if (movie != null) {
        // Movie details
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Main image
            movie.imageUrl.let { imageUrl ->
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // Zastąp ikoną, którą chcesz użyć
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }

            // Movie description
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = movie.description)

            // Additional details like scene breakdown and actors/creators can be added here
        }
    }
}