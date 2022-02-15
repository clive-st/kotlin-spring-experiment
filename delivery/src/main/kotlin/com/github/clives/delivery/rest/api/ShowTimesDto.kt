package com.github.clives.delivery.rest.api

import com.github.clives.core.entities.ShowTimes


data class ShowTimesDto(
        val showTimes: String,
        val price: Long
)

fun ShowTimes.toShowTimesDto() =
        ShowTimesDto(
                showTimes = "Day:${day.name.toLowerCase()} hour:$hour::$minute",
                price = price
        )