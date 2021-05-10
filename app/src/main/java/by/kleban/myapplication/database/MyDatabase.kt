package by.kleban.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.kleban.myapplication.database.dao.DogDao
import by.kleban.myapplication.database.entity.Dog

@Database(entities = [Dog::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun dogDao(): DogDao

    companion object {
        var INSTANCE: MyDatabase? = null
        fun getDatabase(context: Context): MyDatabase {
           return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "database")
                    .build()
                INSTANCE as MyDatabase
            } else {
                INSTANCE as MyDatabase
            }

        }
    }
}