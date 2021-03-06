package com.github.clives.dataproviders.restclient.entities

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.Movie

data class MovieDetailsImdb(
        @JsonProperty("imdbID")
        val imdbID: String,
        @JsonProperty("Title")
        val Title: String
)

fun MovieDetailsImdb.toMovie() =
        Movie(
                imdbID = Imdb(this.imdbID),
                title = this.Title,
                reviews = emptyList()
        )