package com.gahlot.wikipediaapi.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.gahlot.wikipediaapi.data.Page

@Dao
interface LinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(link: VisitedPage)
}