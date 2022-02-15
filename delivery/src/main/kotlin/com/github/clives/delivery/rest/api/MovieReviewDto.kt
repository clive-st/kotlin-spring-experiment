package com.github.clives.delivery.rest.api

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.core.entities.Rating


data class MovieReviewDto(
        val imdbID: String,
        val star: Int,
        val userName: String
)

fun MovieReviewRating.toMovieReviewDto() =
        MovieReviewDto(
                imdbID = this.imdb.value,
                star = this.rating.star,
                userName = this.userName
        )

fun MovieReviewDto.toMovieReview() =
        MovieReviewRating(
                userName = this.userName,
                imdb = Imdb(this.imdbID),
                rating = Rating(this.star)
        )