package com.github.clives.dataproviders.restclient.repositories

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.Movie
import com.github.clives.usecases.gateway.MovieDetailsRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.client.RestTemplate

open class RestTemplateMovieDetailsRepository(private val restTemplate: RestTemplate) :
        MovieDetailsRepository {

    @Value("\${OMDb.root.url}")
    private val baseURL: String? = null

    override fun get(imdb: String): Movie? {
        var tetst: Movie = restTemplate.getForObject("$baseURL/posts/$imdb", Movie::class.java)

        val f:Movie?= Movie(Imdb("111"),"jj2")
        return tetst
    }

}