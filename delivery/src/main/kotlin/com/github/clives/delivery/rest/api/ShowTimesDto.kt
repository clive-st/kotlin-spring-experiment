package com.github.clives.delivery.rest.api

import com.github.clives.core.entities.ShowTimes


data class ShowTimesDto(
        val showTimes: String,
        val price: Long
)

fun ShowTimes.toShowTimesDto() =
        ShowTimesDto(
                showTimes = "test",
                price = 666
        )