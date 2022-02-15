package com.github.clives.dataproviders.db.jpa.repositories

import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.dataproviders.db.jpa.entities.toMovieReviewRating
import com.github.clives.dataproviders.db.jpa.entities.toMovieReviewRatingEntity
import com.github.clives.usecases.gateway.ReviewRepository


open class JpaReviewRepository(private val dbReviewRepository: DBReviewRepository) :
        ReviewRepository {

    override fun insertReview(review: MovieReviewRating): MovieReviewRating =
            dbReviewRepository.save(review.toMovieReviewRatingEntity()).toMovieReviewRating()


}