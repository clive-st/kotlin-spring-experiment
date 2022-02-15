package com.github.clives.dataproviders.restclient.repositories

import com.github.clives.core.entities.Movie
import com.github.clives.dataproviders.restclient.entities.MovieDetailsImdb
import com.github.clives.dataproviders.restclient.entities.toMovie
import com.github.clives.usecases.exceptions.MovieDetailsAccessException
import com.github.clives.usecases.gateway.MovieDetailsRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate

open class RestTemplateMovieDetailsRepository(private val restTemplate: RestTemplate) :
        MovieDetailsRepository {

    @Value("\${OMDb.root.url}")
    private val baseURL: String? = null

    override fun get(imdb: String): Movie? {
        val movieDetailsImdb = try {
            restTemplate.getForObject("$baseURL?i=$imdb", MovieDetailsImdb::class.java)
        } catch (e: RestClientException) {
            throw MovieDetailsAccessException(e.message ?: "general access error")
        }
        return movieDetailsImdb.toMovie()
    }

}