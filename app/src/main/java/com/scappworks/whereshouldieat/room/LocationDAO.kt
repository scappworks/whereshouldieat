package com.scappworks.whereshouldieat.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDAO {
    @Query("SELECT * FROM location_table ORDER BY location_name ASC")
    fun getOrderedLocations(): Flow<List<Location>>

    @Query
    ("SELECT * FROM location_table WHERE category LIKE :category AND always_open LIKE :hours ORDER BY location_name ASC")
    fun getFilteredLocationsSpecific(category: String, hours: String): Flow<List<Location>>

    @Query
    ("SELECT * FROM location_table WHERE category LIKE :category OR always_open LIKE :hours ORDER BY location_name ASC")
    fun getFilteredLocationsUnspecific(category: String, hours: String): Flow<List<Location>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: Location)

    @Query("DELETE FROM location_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(model: Location)
}