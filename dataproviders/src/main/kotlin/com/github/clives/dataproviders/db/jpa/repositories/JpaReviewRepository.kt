package com.github.clives.dataproviders.db.jpa.repositories

import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.dataproviders.db.jpa.repositories.DBShowTimesRepository
import com.github.clives.core.entities.ShowTimes
import com.github.clives.dataproviders.db.jpa.entities.ShowTimesEntity
import com.github.clives.dataproviders.db.jpa.entities.toMovieReviewRating
import com.github.clives.dataproviders.db.jpa.entities.toMovieReviewRatingEntity
import com.github.clives.dataproviders.db.jpa.entities.toShowTimes
import com.github.clives.usecases.gateway.ReviewRepository
import com.github.clives.usecases.gateway.ShowTimesRepository


open class JpaReviewRepository(private val dbReviewRepository: DBReviewRepository) :
        ReviewRepository {

    override fun insertReview(review: MovieReviewRating): MovieReviewRating =
            dbReviewRepository.save(review.toMovieReviewRatingEntity()).toMovieReviewRating()


}