package com.iug.qudsiapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iug.qudsiapp.model.local_storage.News

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var instance: MyDatabase? = null
        fun getDatabase(context: Context): MyDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val _instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my_database"
                ).build()
                instance = _instance
                return _instance
            }
        }
    }
}