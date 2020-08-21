package com.example.monstercreatorapp

import androidx.lifecycle.LiveData
import com.example.monstercreatorapp.dataBase.Check
import com.example.monstercreatorapp.dataBase.CheckDao


class CheckRepository (private val checkDao: CheckDao){


// Room executes all queries on a separate thread.
// Observed LiveData will notify the observer when the data has  changed.
        val allCheckItems: LiveData<List<Check>> =
            checkDao.getAllCheckItems()
        suspend fun insertCheckItem(checkItem: Check) {
            checkDao.insertCheckItem(checkItem)
        }

        suspend fun  updateCheckItems(checkItem: Check){
            checkDao.updateCheckItem(checkItem)
        }
        suspend fun deleteAllCheckItems() {
            val checkArray = allCheckItems.value?.toTypedArray()
            if (checkArray != null) {
                checkDao.clearAllCheckItems(*checkArray)
            }
        }
    }
