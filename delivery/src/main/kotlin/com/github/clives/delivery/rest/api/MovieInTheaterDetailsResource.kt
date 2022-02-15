package com.github.clives.delivery.rest.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletionStage


@RestController
@RequestMapping("/movie")
interface MovieInTheaterDetailsResource {
    @GetMapping("/{imdb}")
    fun getMovieInTheaterDetailsUseCases(@PathVariable("imdb") imdb: String): CompletionStage<MovieInTheaterDetailsDto>

}