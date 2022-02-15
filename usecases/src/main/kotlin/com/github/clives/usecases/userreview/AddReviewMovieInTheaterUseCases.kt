package com.github.clives.usecases.userreview

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.core.entities.Rating
import com.github.clives.core.entities.ShowTimes
import com.github.clives.usecases.UseCase
import com.github.clives.usecases.exceptions.NotFoundException

data class InRequest( val imdb: Imdb,val movieReviewRating: MovieReviewRating)

class AddReviewMovieInTheaterUseCases(private val movieRepository: ReviewRepository) :
        UseCase<InRequest, MovieReviewRating> {
    override fun execute(inRequest: InRequest ) =
            movieRepository.insertReview(inRequest.imdb.value, inRequest.movieReviewRating)

    interface ReviewRepository {
        fun insertReview(imdb: String, review: MovieReviewRating): MovieReviewRating
    }
}