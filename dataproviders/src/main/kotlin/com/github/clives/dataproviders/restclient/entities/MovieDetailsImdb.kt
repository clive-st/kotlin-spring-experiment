package com.github.clives.dataproviders.restclient.entities

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.Movie
import com.github.clives.core.entities.ShowTimes
import com.github.clives.dataproviders.db.jpa.entities.ShowTimesEntity

data class MovieDetailsImdb(
        val imdbID: String,
        val Title: String
)

fun MovieDetailsImdb.toMovie() =
        Movie(
                imdbID = Imdb(this.imdbID),
                title = this.Title
        )