package com.example.movies.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movies.Movie
import com.example.movies.MovieItem

@Composable
fun MainScreen(navController: NavController) {
    Column {
        // List of movies
        LazyColumn {
            items(getSampleMovies()) { movie ->
                MovieItem(movie = movie, onClick = {
                    navController.navigate("descriptionScreen/${movie.id}")
                })
            }
        }
    }
}

fun getSampleMovies(): List<Movie> {
    return listOf(
        Movie(
            id = 1,
            title = "Inception",
            imageUrl = "https://example.com/inception.jpg",
            description = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O."
        ),
        Movie(
            id = 2,
            title = "The Shawshank Redemption",
            imageUrl = "https://example.com/shawshank.jpg",
            description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
        ),
        Movie(
            id = 3,
            title = "The Dark Knight",
            imageUrl = "https://example.com/darkknight.jpg",
            description = "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham."
        )
    )
}