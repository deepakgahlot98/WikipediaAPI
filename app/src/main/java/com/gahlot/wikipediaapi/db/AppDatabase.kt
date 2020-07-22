package com.gahlot.wikipediaapi.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gahlot.wikipediaapi.data.Page

@Database(entities = [VisitedPage::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun linkDao(): LinkDao
}