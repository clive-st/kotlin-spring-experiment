package com.github.clives.dataproviders.db.jpa.repositories

import com.github.clives.dataproviders.db.jpa.entities.ShowTimesEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DBShowTimesRepository : JpaRepository<ShowTimesEntity, String>