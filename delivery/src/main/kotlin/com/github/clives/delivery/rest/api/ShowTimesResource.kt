package com.github.clives.delivery.rest.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage


@RestController
@RequestMapping("/showtimes")
interface ShowTimesResourceResource {
    @GetMapping("/{imdb}")
    fun fetchShowTimesMovieInTheater(@PathVariable("imdb") imdb: String): CompletionStage<List<ShowTimesDto>>

}