package com.example.movies.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movies.Movie
import com.example.movies.MovieItem
import com.example.movies.R

@Composable
fun MainScreen(navController: NavController) {
    Column {
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
            title = "The Shawshank Redemption",
            image = R.drawable.the_shawshank_redemption,
            description = "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion."
        ),
        Movie(
            id = 2,
            title = "The Truman show",
            image = R.drawable.the_truman_show,
            description = "An insurance salesman discovers his whole life is actually a reality TV show."
        ),
        Movie(
            id = 3,
            title = "The Devil Wears Prada",
            image = R.drawable.the_devil_wears_prada,
            description = "A smart but sensible new graduate lands a job as an assistant to Miranda Priestly, the demanding editor-in-chief of a high fashion magazine."
        )
    )
}