package com.scappworks.whereshouldieat.room

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class LocationRepository(private val locationDAO: LocationDAO) {
    private var category = ""
    private var allHours = ""
    val allLocations: Flow<List<Location>> = locationDAO.getOrderedLocations()
    var filteredLocations: Flow<List<Location>> = locationDAO.getFilteredLocationsUnspecific(category, allHours)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(location: Location) {
        locationDAO.insertLocation(location)
    }

    fun setFilteredLocations(c: String, ah: String): Flow<List<Location>> {
        filteredLocations = when {
            c == "Any" || ah == "Any" -> {
                locationDAO.getFilteredLocationsUnspecific(c, ah)
            }
            else -> {
                locationDAO.getFilteredLocationsSpecific(c, ah)
            }
        }

        return filteredLocations
    }

    @WorkerThread
    suspend fun delete(location: Location) {
        locationDAO.delete(location)
    }
}