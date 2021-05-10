package by.kleban.myapplication.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import by.kleban.myapplication.database.entity.Dog

@Dao
interface DogDao {

    @Query("SELECT * FROM table_dog")
    suspend fun getAll(): List<Dog>

    @Insert
    suspend fun insertDog(dog: Dog)

    @Update
    suspend fun update(dog: Dog)

}