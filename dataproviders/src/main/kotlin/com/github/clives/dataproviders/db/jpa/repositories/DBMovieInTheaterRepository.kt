package com.github.aantoniadis.dataproviders.db.jpa.repositories

import com.github.clives.dataproviders.db.jpa.entities.MovieInTheaterEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DBMovieInTheaterRepository : JpaRepository<MovieInTheaterEntity, String>