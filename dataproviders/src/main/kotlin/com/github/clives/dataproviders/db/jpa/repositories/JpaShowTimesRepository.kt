package com.github.clives.dataproviders.db.jpa.repositories

import com.github.clives.core.entities.ShowTimes
import com.github.clives.dataproviders.db.jpa.entities.ShowTimesEntity
import com.github.clives.dataproviders.db.jpa.entities.toShowTimes
import com.github.clives.usecases.gateway.ShowTimesRepository

open class JpaShowTimesRepository(private val dbShowTimesRepository: DBShowTimesRepository) :
        ShowTimesRepository {

    override fun fetchMovieTimesByIMDB(imdb: String): List<ShowTimes> =
            dbShowTimesRepository.findAllById(listOf(imdb)).map(ShowTimesEntity::toShowTimes)

}