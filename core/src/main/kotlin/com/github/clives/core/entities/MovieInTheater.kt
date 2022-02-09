package com.github.clives.core.entities

data class MovieInTheater(
        val imdbId: Imdb,
        val showTimes: List<ShowTimes>
)

data class ShowTimes(
        val day: Int,
        val hour: Int,
        val minute:  Int,
        val price: Long
)

data class Imdb(val value: String) {
    companion object {
        operator fun invoke(imdb: String): Imdb {
            //todo validation regexp,...
            return Imdb(imdb)
        }
    }
}