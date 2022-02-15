package com.github.clives.delivery.rest.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletionStage


@RestController
@RequestMapping("/movie/review")
interface MovieReviewResource {

    @PostMapping
    fun insertMovieReview(movieReviewDto: MovieReviewDto): CompletionStage<MovieReviewDto>

}