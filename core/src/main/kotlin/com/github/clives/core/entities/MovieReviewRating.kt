package com.github.clives.core.entities

data class MovieReviewRating (
    val rating: Rating,
    val userName: String
)

data class Rating (val nbrStarval :Int){
    companion object {
        operator fun invoke(rating: Int): Rating {
            //todo validation
            return Rating(rating)
        }
    }
}