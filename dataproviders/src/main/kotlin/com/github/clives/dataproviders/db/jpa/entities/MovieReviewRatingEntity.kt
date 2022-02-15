package com.github.clives.dataproviders.db.jpa.entities

import com.github.clives.core.entities.Day
import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.core.entities.Rating
import com.github.clives.core.entities.ShowTimes
import javax.persistence.*

@Entity
@Table(name = "movie_rating")
data class MovieReviewRatingEntity(
        val imdbId: String,
        val rating: Int,
        val userName: String,
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0
)

// Mappers
fun MovieReviewRatingEntity.toMovieReviewRating() =
        MovieReviewRating(
                rating = Rating(rating),
                userName= userName
        )

fun MovieReviewRating.toMovieReviewRatingEntity(imdb:String) =
        MovieReviewRatingEntity(
                imdbId = imdb,
                rating = rating.nbrStarval,
                userName= userName
        )