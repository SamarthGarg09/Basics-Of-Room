package com.example.busschedule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao
import java.lang.IllegalArgumentException

class BusScheduleViewModel (private val scheduleDao: ScheduleDao):ViewModel(){
    fun fullSchedule():List<Schedule> = scheduleDao.getAll()
    fun scheduleFromStopName(stopName:String):List<Schedule> = scheduleDao.getByStopName(stopName)
}

class BusScheduleViewModelFactory(private val scheduleDao: ScheduleDao):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BusScheduleViewModel::class.java))
            return BusScheduleViewModel(scheduleDao) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}