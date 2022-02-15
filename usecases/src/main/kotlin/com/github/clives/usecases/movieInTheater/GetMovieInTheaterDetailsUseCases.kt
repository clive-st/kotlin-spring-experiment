package com.github.clives.usecases.movieInTheater

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.Movie
import com.github.clives.core.entities.MovieInTheater
import com.github.clives.core.entities.ShowTimes
import com.github.clives.usecases.UseCase
import com.github.clives.usecases.exceptions.NotFoundException
import com.github.clives.usecases.gateway.ShowTimesRepository


class GetMovieInTheaterDetailsUseCases(private val movieRepository: MovieInTheaterRepository, private val movieDetailsRepository: MovieDetailsRepository) :
        UseCase<Imdb, Movie> {

    override fun execute(imdbID: Imdb) =
            movieRepository.get(imdbID.value)?.let {
                service ->
                println(service.reviewRating)
                movieDetailsRepository.get(imdbID.value)?: throw NotFoundException("No movie details for imdb: $imdbID")
            }?: throw NotFoundException("No theater movie for imdb: $imdbID")

    interface MovieInTheaterRepository {
        fun exist(imdb: String): Boolean
        fun get(imdb: String): MovieInTheater?
    }

    interface MovieDetailsRepository {
        fun get(imdb: String): Movie?
    }
}