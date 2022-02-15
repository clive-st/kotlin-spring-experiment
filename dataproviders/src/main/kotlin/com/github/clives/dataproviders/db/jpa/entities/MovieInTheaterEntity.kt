package com.github.clives.dataproviders.db.jpa.entities

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.MovieInTheater
import javax.persistence.*

@Entity
@Table(name = "movie_in_theater")
data class MovieInTheaterEntity(
        @Id
        val imdbId: String,

        val title: String,

        @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, mappedBy = "imdbId")
        val reviews: Collection<MovieReviewEntity>,

        @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, mappedBy = "imdbId")
        val showTimes: Collection<ShowTimesEntity>
)


// Mappers
fun MovieInTheaterEntity.toMovie() =
        MovieInTheater(
                imdbId = Imdb(this.imdbId),
                showTimes = emptyList(),
                title = title,
                reviewRating = reviews.map(MovieReviewEntity::toMovieReviewRating)
        )