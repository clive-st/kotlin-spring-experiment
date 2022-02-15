package com.github.clives.delivery.rest.api

import com.github.clives.core.entities.Movie
import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.core.entities.ShowTimes


data class MovieInTheaterDetailsDto(
        val title: String,
        val imdbID: String,
        val reviews: Collection<MovieReviewRating>
)

fun Movie.toMovieInTheaterDetailsDto() =
        MovieInTheaterDetailsDto(
                imdbID = this.imdbID.value,
                title = this.title,
                reviews = this.reviews
        )