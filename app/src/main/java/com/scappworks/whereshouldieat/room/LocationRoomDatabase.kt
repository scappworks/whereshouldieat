package com.scappworks.whereshouldieat.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Location::class), version = 1_7, exportSchema = false)
abstract class LocationRoomDatabase : RoomDatabase() {
    abstract fun locationDAO(): LocationDAO

    companion object {
        @Volatile
        private var INSTANCE: LocationRoomDatabase? = null

        fun getDatabase(context: Context,
        scope: CoroutineScope): LocationRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocationRoomDatabase::class.java,
                    "location_database")
                        .addCallback(LocationDatabaseCallback(scope))
                        //.fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance

                instance
            }
        }
    }

    private class LocationDatabaseCallback(
            private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.locationDAO())
                }
            }
        }

        suspend fun populateDatabase(locationDAO: LocationDAO) {
            // Delete all content here.
            locationDAO.deleteAll()
        }
    }
}