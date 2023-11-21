package com.example.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class Movie(val id: Int, val title: String, val image: Int, val description: String, val scenes: List<Scene>, val cast: List<Actor>)
data class Scene(val image: Int)
data class Actor(val name: String, val image: Int)

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = movie.image),
            contentDescription = movie.description,
            modifier = Modifier
                .height(200.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = movie.title)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

fun getSampleMovies(): List<Movie> {
    return listOf(
        Movie(
            id = 1,
            title = "The Shawshank Redemption",
            image = R.drawable.the_shawshank_redemption_poster,
            description = "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.",
            scenes = listOf(
                Scene(R.drawable.the_shawshank_redemption_scene1),
                Scene(R.drawable.the_shawshank_redemption_scene2),
                Scene(R.drawable.the_shawshank_redemption_scene3),
                Scene(R.drawable.the_shawshank_redemption_scene4),
                Scene(R.drawable.the_shawshank_redemption_scene5),
                Scene(R.drawable.the_shawshank_redemption_scene6),
                Scene(R.drawable.the_shawshank_redemption_scene7),
                Scene(R.drawable.the_shawshank_redemption_scene8),
                Scene(R.drawable.the_shawshank_redemption_scene9)
            ),
            cast = listOf(
                Actor("Tom Robbins", R.drawable.the_shawshank_redemption_actor1),
                Actor("Morgan Freeman", R.drawable.the_shawshank_redemption_actor2),
                Actor("Bob Gunton", R.drawable.the_shawshank_redemption_actor3),
                Actor("William Sandler", R.drawable.the_shawshank_redemption_actor4),
                Actor("Clancy Brown", R.drawable.the_shawshank_redemption_actor5),
                Actor("Gil Bellows", R.drawable.the_shawshank_redemption_actor6)
            )
        ),
        Movie(
            id = 2,
            title = "The Truman show",
            image = R.drawable.the_truman_show_poster,
            description = "An insurance salesman discovers his whole life is actually a reality TV show.",
            scenes = listOf(
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground)
            ),
            cast = listOf(
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground)
            )
        ),
        Movie(
            id = 3,
            title = "The Devil Wears Prada",
            image = R.drawable.the_devil_wears_prada_poster,
            description = "A smart but sensible new graduate lands a job as an assistant to Miranda Priestly, the demanding editor-in-chief of a high fashion magazine.",
            scenes = listOf(
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground),
                Scene(R.drawable.ic_launcher_foreground)
            ),
            cast = listOf(
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground),
                Actor("", R.drawable.ic_launcher_foreground)
            )
        )
    )
}


