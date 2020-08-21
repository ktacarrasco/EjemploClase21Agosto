package com.example.monstercreatorapp.dataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CheckDao {



        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertCheckItem(check: Check)
        @Update
        suspend fun updateCheckItem(check: Check)
        @Delete
        suspend fun clearAllCheckItems(vararg creature: Check)
        @Query("SELECT * FROM check_items ORDER BY name ASC")
        fun getAllCheckItems(): LiveData<List<Check>>


}