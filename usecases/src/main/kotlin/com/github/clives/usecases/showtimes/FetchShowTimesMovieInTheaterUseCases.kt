package com.github.clives.usecases.showtimes

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.ShowTimes
import com.github.clives.usecases.UseCase
import com.github.clives.usecases.exceptions.NotFoundException


class FetchShowTimesMovieInTheaterUseCases(private val movieRepository: ShowTimesRepository) :
        UseCase<Imdb, List<ShowTimes>> {
    override fun execute(imdbID: Imdb) =
            movieRepository.fetchMovieTimesByIMDB(imdbID.value)
                    ?: throw NotFoundException("No show times for imdb: $imdbID")

    interface ShowTimesRepository {
        fun fetchMovieTimesByIMDB(imdb: String): List<ShowTimes>
    }
}