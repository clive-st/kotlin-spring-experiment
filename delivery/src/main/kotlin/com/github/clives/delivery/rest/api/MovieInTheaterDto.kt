package com.github.clives.delivery.rest.api

import com.github.clives.core.entities.Movie
import com.github.clives.core.entities.ShowTimes


data class MovieInTheaterDetailsDto(
        val title: String,
        val imdbID: String
)

fun Movie.toMovieInTheaterDetailsDto() =
        MovieInTheaterDetailsDto(
                imdbID = this.imdbID.value,
                title = this.title
        )