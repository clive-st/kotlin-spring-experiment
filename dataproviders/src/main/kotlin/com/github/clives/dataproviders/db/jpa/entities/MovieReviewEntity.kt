package com.github.clives.dataproviders.db.jpa.entities

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.core.entities.Rating
import javax.persistence.*

@Entity
@Table(name = "movie_rating")
data class MovieReviewEntity(
        val imdbId: String,
        val rating: Int,
        val userName: String,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0
)

// Mappers
fun MovieReviewEntity.toMovieReviewRating() =
        MovieReviewRating(
                rating = Rating(rating),
                userName = userName,
                imdb = Imdb(imdbId)
        )

fun MovieReviewRating.toMovieReviewRatingEntity() =
        MovieReviewEntity(
                imdbId = imdb.value,
                rating = rating.star,
                userName = userName
        )