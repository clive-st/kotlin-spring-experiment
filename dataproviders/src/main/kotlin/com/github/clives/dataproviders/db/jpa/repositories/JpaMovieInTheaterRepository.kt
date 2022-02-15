package com.github.clives.dataproviders.db.jpa.repositories

import com.github.clives.core.entities.Imdb
import com.github.clives.core.entities.MovieInTheater
import com.github.clives.dataproviders.db.jpa.entities.MovieInTheaterEntity
import com.github.clives.dataproviders.db.jpa.entities.toMovie
import com.github.clives.usecases.gateway.MovieInTheaterRepository

open class JpaMovieInTheaterRepository(private val dbCinemaMovieRepository: DBMovieInTheaterRepository): MovieInTheaterRepository {
       fun findAll() =
            dbCinemaMovieRepository.findAll().map(MovieInTheaterEntity::toMovie)

       override fun exist(imdb:String) =
               dbCinemaMovieRepository.existsById(imdb)

       override fun get(imdb: String): MovieInTheater? =
              dbCinemaMovieRepository.findById(imdb).map(MovieInTheaterEntity::toMovie).unwrap()

}