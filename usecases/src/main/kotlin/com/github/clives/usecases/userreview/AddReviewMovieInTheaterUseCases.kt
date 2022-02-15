package com.github.clives.usecases.userreview

import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.usecases.UseCase


class AddReviewMovieInTheaterUseCases(private val movieRepository: ReviewRepository) :
        UseCase<MovieReviewRating, MovieReviewRating> {
    override fun execute(movieReviewRating: MovieReviewRating) =
            movieRepository.insertReview(movieReviewRating)

    interface ReviewRepository {
        fun insertReview(review: MovieReviewRating): MovieReviewRating
    }
}