package com.github.clives.delivery.rest.api.imp

import com.github.clives.core.entities.Imdb
import com.github.clives.delivery.rest.api.ShowTimesResourceResource
import com.github.clives.delivery.rest.api.toShowTimesDto
import com.github.clives.usecases.UseCaseExecutor
import com.github.clives.usecases.showtimes.FetchShowTimesMovieInTheaterUseCases
import org.springframework.web.bind.annotation.PathVariable


class ShowTimesResourceImp(
        private val useCaseExecutor: UseCaseExecutor,
        private val fetchShowTimesMovieInTheaterUseCases: FetchShowTimesMovieInTheaterUseCases
) : ShowTimesResourceResource {

    override fun fetchShowTimesMovieInTheater(@PathVariable("imdb") imdb: String) =
            useCaseExecutor(
                    useCase = fetchShowTimesMovieInTheaterUseCases,
                    requestDto = imdb,
                    requestConverter = { Imdb(it) },
                    responseConverter = { it.map { it.toShowTimesDto() } }
            )


}