package com.github.clives.dataproviders.db.jpa.entities

import com.github.clives.core.entities.*
import javax.persistence.*

@Entity
@Table(name = "movie_rating")
data class MovieReviewRatingEntity(
        val imdbId: String,
        val rating: Int,
        val userName: String,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0
)

// Mappers
fun MovieReviewRatingEntity.toMovieReviewRating() =
        MovieReviewRating(
                rating = Rating(rating),
                userName= userName,
                imdb = Imdb(imdbId)
        )

fun MovieReviewRating.toMovieReviewRatingEntity() =
        MovieReviewRatingEntity(
                imdbId = imdb.value,
                rating = rating.star,
                userName= userName
        )