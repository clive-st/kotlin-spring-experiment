package com.github.clives.dataproviders.db.jpa.entities

import com.github.clives.core.entities.ShowTimes
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

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