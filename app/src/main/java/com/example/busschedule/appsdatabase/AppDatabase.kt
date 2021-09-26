package com.example.busschedule.appsdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao

@Database(entities = [Schedule::class],version = 1)
abstract class AppDatabase():RoomDatabase() {
    abstract fun scheduleDao():ScheduleDao
    companion object{
        private fun getDatabse(context: Context):AppDatabase{
            var INSTANCE:AppDatabase? = null
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}