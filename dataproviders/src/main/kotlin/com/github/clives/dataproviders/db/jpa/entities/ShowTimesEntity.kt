package com.github.clives.dataproviders.db.jpa.entities

import com.github.clives.core.entities.Day
import com.github.clives.core.entities.ShowTimes
import javax.persistence.*

@Entity
@Table(name = "show_time")
data class ShowTimesEntity(
        val imdbId: String,

        val day: Int,

        val hour: Int,

        val minute: Int,

        val price: Long,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0
)

// Mappers
fun ShowTimesEntity.toShowTimes() =
        ShowTimes(
                day = Day.valueOf(day)!!,
                hour = hour,
                minute = minute,
                price = price
        )

fun ShowTimes.toShowTimesEntity(imdb: String) =
        ShowTimesEntity(
                imdbId = imdb,
                day = day.value,
                hour = hour,
                minute = minute,
                price = price
        )