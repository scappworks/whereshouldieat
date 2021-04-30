package com.scappworks.whereshouldieat.viewmodel

import androidx.lifecycle.*
import com.scappworks.whereshouldieat.room.Location
import com.scappworks.whereshouldieat.room.LocationRepository
import kotlinx.coroutines.launch

class LocationViewModel(private val repository: LocationRepository) : ViewModel() {
    val allLocations: LiveData<List<Location>> = repository.allLocations.asLiveData()
    var filteredLocations: LiveData<List<Location>> = repository.filteredLocations.asLiveData()
    fun insert(location: Location) = viewModelScope.launch { repository.insert(location) }
    fun delete(location: Location) = viewModelScope.launch { repository.delete(location) }
    fun setFilter(category: String, all_hours: String) = viewModelScope.launch { repository.setFilteredLocations(
            category, all_hours)
        filteredLocations = repository.filteredLocations.asLiveData()}
}

@Suppress("UNCHECKED_CAST")
class LocationViewModelFactory(private val repository: LocationRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LocationViewModel::class.java)) {
            @Suppress("UNCHECKED CAST")
            return LocationViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}