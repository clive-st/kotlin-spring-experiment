package com.github.clives.dataproviders.db.jpa.entities

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.MovieInTheater
import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.core.entities.ShowTimes
import javax.persistence.*

@Entity
@Table(name = "movie_in_theater")
data class MovieInTheaterEntity(
        @Id
        val imdbId: String,

        val title: String,

        @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, mappedBy = "imdbId")
        //@JoinColumn(name="id")
        val reviews: Collection<MovieReviewRatingEntity>
        )


// Mappers
fun MovieInTheaterEntity.toMovie() =
        MovieInTheater(
                imdbId = Imdb(this.imdbId),
                showTimes = emptyList(),
                title = title,
                reviewRating = reviews.map( MovieReviewRatingEntity::toMovieReviewRating)
        )

/*
fun MovieInTheater.toMovieInTheaterEntity() =
        MovieInTheaterEntity(
                imdbId = this.imdbId.value,
                title = this.title
             //   showTimes = emptyList()
        )*/