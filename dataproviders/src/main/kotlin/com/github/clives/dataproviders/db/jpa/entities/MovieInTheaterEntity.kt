package com.github.clives.dataproviders.db.jpa.entities

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.MovieInTheater
import com.github.clives.core.entities.ShowTimes
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "movie_in_theater")
data class MovieInTheaterEntity(
        @Id
        val imdbId: String,

        @OneToMany//(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val showTimes: List<ShowTimesEntity>
)


// Mappers
fun MovieInTheaterEntity.toMovie() =
        MovieInTheater(
                imdbId = Imdb(this.imdbId),
                showTimes = emptyList()
        )

fun MovieInTheater.toMovieInTheaterEntity() =
        MovieInTheaterEntity(
                imdbId = this.imdbId.value,
                showTimes = emptyList()
        )