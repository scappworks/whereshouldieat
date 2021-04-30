package com.scappworks.whereshouldieat.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class Location (
        @PrimaryKey
        @ColumnInfo(name = "location_name") val location_name: String,
        @ColumnInfo(name = "category") val category: String,
        @ColumnInfo(name = "always_open") val always_open: String
        )