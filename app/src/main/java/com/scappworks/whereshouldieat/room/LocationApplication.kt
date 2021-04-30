package com.scappworks.whereshouldieat.room

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class LocationApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { LocationRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { LocationRepository(database.locationDAO()) }
}