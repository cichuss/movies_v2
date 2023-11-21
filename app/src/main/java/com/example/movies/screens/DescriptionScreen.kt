package com.example.movies.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.movies.Actor
import com.example.movies.R
import com.example.movies.Scene
import com.example.movies.getSampleMovies

@Composable
fun DescriptionScreen(movieId: Int) {
    val movie = getSampleMovies().find { it.id == movieId }

    if (movie != null) {
        var selectedTabIndex by remember { mutableIntStateOf(0) }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = movie.image),
                contentDescription = movie.description,
                modifier = Modifier
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )
            Text("Description")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = movie.description)
            Spacer(modifier = Modifier.height(16.dp))

            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                // Tab for Details
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 }
                ) {
                    Text("Scenes")
                }

                // Tab for Scenes
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 }
                ) {
                    Text("Actors")
                }
            }

            // Display content based on the selected tab
            when (selectedTabIndex) {
                0 -> {
                    // Show Scenes content
                    ScenesContent(movie.scenes)
                }

                else -> {
                   CastContent(movie.cast)
                }
            }
        }
    }
}

@Composable
fun ScenesContent(scenes: List<Scene>) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(scenes) { scene ->
            ZoomableImage(image = scene.image)
        }
    }
}

@Composable
fun CastContent(actors: List<Actor>) {
    // Display actors with names and zoomable images
    LazyColumn {
        items(actors) { actor ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Zoomable image of the actor
                ZoomableImage(image = actor.image, modifier = Modifier.size(100.dp))

                // Actor's name
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = actor.name)
            }
        }
    }
}

@Composable
fun ZoomableImage(image: Int, modifier: Modifier = Modifier) {
    // You can use a library like Coil or Accompanist to load images
    Image(
        painter = painterResource(id = image), // Placeholder image
        contentDescription = null,
        modifier = modifier
            .background(MaterialTheme.colorScheme.onSurface)
            .clickable {
//                ShowZoomedInView(image = image)
            }
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ShowZoomedInView(image: Int) {
    Dialog(
        onDismissRequest = { /* Handle dismiss if needed */ }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Display the zoomed-in image
            ZoomableImage(image = image, modifier = Modifier.fillMaxSize())
        }
    }
}
