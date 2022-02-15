package com.github.clives.delivery.rest.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletionStage


@RestController
@RequestMapping("/showtimes")
interface ShowTimesResourceResource {
    @GetMapping("/{imdb}")
    fun fetchShowTimesMovieInTheater(@PathVariable("imdb") imdb: String): CompletionStage<List<ShowTimesDto>>

}