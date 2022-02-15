package com.github.clives.delivery.rest.api.imp

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.delivery.rest.api.*
import com.github.clives.usecases.UseCaseExecutor
import com.github.clives.usecases.showtimes.FetchShowTimesMovieInTheaterUseCases
import org.springframework.web.bind.annotation.PathVariable
import com.github.clives.usecases.userreview.AddReviewMovieInTheaterUseCases
import org.springframework.web.bind.annotation.RequestBody


class MovieReviewResourceImp(
        private val useCaseExecutor: UseCaseExecutor,
        private val insertReview: AddReviewMovieInTheaterUseCases
) : MovieReviewResource {

    override fun insertMovieReview(@RequestBody movieReviewDto: MovieReviewDto) = useCaseExecutor(
                useCase = insertReview,
                requestDto = movieReviewDto,
                requestConverter = { movieReviewDto.toMovieReview() },
                responseConverter = { it.toMovieReviewDto() }
        )


}