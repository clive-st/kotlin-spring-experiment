package com.github.clives.delivery.rest.api.imp

import com.github.clives.delivery.rest.api.MovieReviewDto
import com.github.clives.delivery.rest.api.MovieReviewResource
import com.github.clives.delivery.rest.api.toMovieReview
import com.github.clives.delivery.rest.api.toMovieReviewDto
import com.github.clives.usecases.UseCaseExecutor
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