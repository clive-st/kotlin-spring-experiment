package com.github.clives.dataproviders.db.jpa.repositories

import com.github.clives.core.entities.MovieReviewRating
import com.github.clives.dataproviders.db.jpa.entities.MovieReviewRatingEntity
import com.github.clives.dataproviders.db.jpa.entities.ShowTimesEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DBReviewRepository : JpaRepository<MovieReviewRatingEntity, String>