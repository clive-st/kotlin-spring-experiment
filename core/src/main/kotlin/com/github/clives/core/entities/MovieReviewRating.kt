package com.github.clives.core.entities

data class MovieReviewRating(
        val imdb: Imdb,
        val rating: Rating,
        val userName: String
)

data class Rating(val star: Int) {
    companion object {
        operator fun invoke(star: Int): Rating {
            //todo validation (1 to 5)
            return Rating(star)
        }
    }
}