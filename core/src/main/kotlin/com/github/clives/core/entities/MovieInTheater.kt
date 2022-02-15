package com.github.clives.core.entities

data class MovieInTheater(
        val imdbId: Imdb,
        val title: String,
        val showTimes: List<ShowTimes>,
        val reviewRating: Collection<MovieReviewRating>
)

data class ShowTimes(
        val day: Day,
        val hour: Int,
        val minute: Int,
        val price: Long
)

enum class Day(val value: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(5),
    SUNDAY(6);

    companion object {
        fun valueOf(value: Int) = Day.values().find { it.value == value }
    }
}

data class Imdb(val value: String) {
    companion object {
        operator fun invoke(imdb: String): Imdb {
            //todo validation regexp,...
            return Imdb(imdb)
        }
    }
}