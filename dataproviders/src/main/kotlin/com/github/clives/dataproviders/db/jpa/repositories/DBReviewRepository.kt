package com.github.clives.dataproviders.db.jpa.repositories

import com.github.clives.dataproviders.db.jpa.entities.MovieReviewEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DBReviewRepository : JpaRepository<MovieReviewEntity, String>