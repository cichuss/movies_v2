package com.example.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Movie(val id: Int, val title: String, val image: Int, val description: String, val scenes: List<Scene>, val cast: List<Actor>, val directors: List<String>, val writers: List<String>, val releaseDate: String, val duration: String, val genre: String, val trailers: List<Trailer>)
data class Scene(val image: Int)
data class Trailer(val trailer: Int)
data class Actor(val name: String, val image: Int)

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onClick()
            }
    ) {
        Image(
            painter = painterResource(id = movie.image),
            contentDescription = movie.description,
            modifier = Modifier
                .height(250.dp)
                .width(180.dp)
                .padding(10.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        Text(
            text = movie.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
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
            ),
            directors = listOf("Frank Darabont"),
            writers = listOf(
                "Stephen King",
                "Frank Darabont"),
            duration = "2h 22m",
            releaseDate = "1994",
            genre = "Drama",
            trailers = listOf(
                Trailer(R.raw.the_shawshank_redemption_t1),
                Trailer(R.raw.the_shawshank_redemption_t2),
                Trailer(R.raw.the_shawshank_redemption_t3)
            )
        ),
        Movie(
            id = 2,
            title = "The Truman show",
            image = R.drawable.the_truman_show_poster,
            description = "An insurance salesman discovers his whole life is actually a reality TV show.",
            scenes = listOf(
                Scene(R.drawable.the_truman_show_scene1),
                Scene(R.drawable.the_truman_show_scene2),
                Scene(R.drawable.the_truman_show_scene3),
                Scene(R.drawable.the_truman_show_scene4),
                Scene(R.drawable.the_truman_show_scene5),
                Scene(R.drawable.the_truman_show_scene6),
                Scene(R.drawable.the_truman_show_scene7),
                Scene(R.drawable.the_truman_show_scene8),
                Scene(R.drawable.the_truman_show_scene9)
            ),
            cast = listOf(
                Actor("Jim Carrey", R.drawable.the_truman_show_actor1),
                Actor("Laura Linney", R.drawable.the_truman_show_actor2),
                Actor("Noah Emmerich", R.drawable.the_truman_show_actor3),
                Actor("Natascha McElhone", R.drawable.the_truman_show_actor4),
                Actor("Ed Harris", R.drawable.the_truman_show_actor5)
            ),
            directors = listOf("Peter Weir"),
            writers = listOf("Andrew Niccol"),
            duration = "1h 43m",
            releaseDate = "1998",
            genre = "Comedy/Drama",
            trailers = listOf(
                Trailer(R.raw.the_truman_show_t1),
                Trailer(R.raw.the_truman_show_t2),
                Trailer(R.raw.the_truman_show_t3)
            )
        ),
        Movie(
            id = 3,
            title = "The Devil Wears Prada",
            image = R.drawable.the_devil_wears_prada_poster,
            description = "A smart but sensible new graduate lands a job as an assistant to Miranda Priestly, the demanding editor-in-chief of a high fashion magazine.",
            scenes = listOf(
                Scene(R.drawable.the_devil_wears_prada_scene1),
                Scene(R.drawable.the_devil_wears_prada_scene2),
                Scene(R.drawable.the_devil_wears_prada_scene3),
                Scene(R.drawable.the_devil_wears_prada_scene4),
                Scene(R.drawable.the_devil_wears_prada_scene5),
                Scene(R.drawable.the_devil_wears_prada_scene6),
                Scene(R.drawable.the_devil_wears_prada_scene7),
                Scene(R.drawable.the_devil_wears_prada_scene8),
                Scene(R.drawable.the_devil_wears_prada_scene9)
            ),
            cast = listOf(
                Actor("Meryl Streep", R.drawable.the_devil_wears_prada_actor1),
                Actor("Anne Hathaway", R.drawable.the_devil_wears_prada_actor2),
                Actor("Emily Blunt", R.drawable.the_devil_wears_prada_actor3),
                Actor("Stanley Tucci", R.drawable.the_devil_wears_prada_actor4),
                Actor("Adrian Grenier", R.drawable.the_devil_wears_prada_actor5),
                Actor("Tracie Thoms", R.drawable.the_devil_wears_prada_actor6)
            ),
            directors = listOf("David Frankel"),
            writers = listOf(
                "Aline Brosh McKenna",
                "Lauren Weisberger"),
            duration = "1h 49m",
            releaseDate = "2006",
            genre = "Comedy/Drama",
            trailers = listOf(
                Trailer(R.raw.the_devil_wears_prada_t1),
                Trailer(R.raw.the_devil_wears_prada_t2),
                Trailer(R.raw.the_devil_wears_prada_t3)
            )
        )
    )
}
