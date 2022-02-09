package com.github.clives.dataproviders.db.jpa.repositories

import com.github.clives.dataproviders.db.jpa.entities.MovieInTheaterEntity
import com.github.clives.dataproviders.db.jpa.entities.toMovie

open class JpaMovieInTheaterRepository(private val dbCinemaMovieRepository: DBMovieInTheaterRepository) {
       fun findAll() =
            dbCinemaMovieRepository.findAll().map(MovieInTheaterEntity::toMovie)

}