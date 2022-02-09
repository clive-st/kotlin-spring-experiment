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

@Entity
@Table(name = "show_time")
data class ShowTimesEntity(
        @Id
        val imdbId: String,

        val day: Int,

        val hour: Int,

        val minute: Int,

        val price: Long
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

// Mappers
fun ShowTimesEntity.toShowTimes() =
        ShowTimes(
                day = 1,
                hour = 1,
                minute = 2,
                price = 3
        )

fun ShowTimes.toShowTimesEntity(imdb:String) =
        ShowTimesEntity(
                imdbId=imdb,
                day = 1,
                hour = 1,
                minute = 2,
                price = 3
        )