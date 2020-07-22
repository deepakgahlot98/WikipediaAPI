package com.gahlot.wikipediaapi.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "visited")
data class VisitedPage(
        @PrimaryKey
        @ColumnInfo(name = "visitedLink")
        val first: String)