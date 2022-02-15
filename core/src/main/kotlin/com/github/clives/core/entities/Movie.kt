package com.github.clives.core.entities

data class Movie(
        val imdbID: Imdb,
        val title: String,
        val reviews: Collection<MovieReviewRating>
)