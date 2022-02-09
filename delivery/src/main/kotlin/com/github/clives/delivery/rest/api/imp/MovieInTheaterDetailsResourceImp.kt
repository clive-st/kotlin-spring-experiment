package com.github.clives.delivery.rest.api.imp

import com.github.clives.core.entities.Imdb
import com.github.clives.delivery.rest.api.MovieInTheaterDetailsResource
import com.github.clives.delivery.rest.api.ShowTimesResourceResource
import com.github.clives.delivery.rest.api.toMovieInTheaterDetailsDto
import com.github.clives.usecases.UseCaseExecutor
import org.springframework.web.bind.annotation.PathVariable
import com.github.clives.usecases.movieInTheater.GetMovieInTheaterDetailsUseCases


class MovieInTheaterDetailsResourceImp(
        private val useCaseExecutor: UseCaseExecutor,
        private val getMovieInTheaterDetailsUseCases: GetMovieInTheaterDetailsUseCases
) : MovieInTheaterDetailsResource {

    override fun getMovieInTheaterDetailsUseCases(@PathVariable("imdb") imdb: String) =
        useCaseExecutor(
            useCase = getMovieInTheaterDetailsUseCases,
            requestDto = imdb,
            requestConverter = { Imdb(it) },
            responseConverter = { it.toMovieInTheaterDetailsDto() }
        )


}