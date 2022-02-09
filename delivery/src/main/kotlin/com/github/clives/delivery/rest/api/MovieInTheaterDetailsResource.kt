package com.github.clives.delivery.rest.api

import com.github.clives.core.entities.MovieInTheater
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage


@RestController
@RequestMapping("/movie")
interface MovieInTheaterDetailsResource {
    @GetMapping("/{imdb}")
    fun getMovieInTheaterDetailsUseCases(@PathVariable("imdb") imdb: String): CompletionStage<MovieInTheaterDetailsDto>

}