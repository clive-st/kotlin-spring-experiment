package com.github.clives.delivery.rest.api

import com.github.clives.core.entities.MovieInTheater
import com.github.clives.core.entities.MovieReviewRating
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletionStage


@RestController
@RequestMapping("/movie/review")
interface MovieReviewResource {

    @PostMapping
    fun insertMovieReview( movieReviewDto: MovieReviewDto): CompletionStage<MovieReviewDto>

}