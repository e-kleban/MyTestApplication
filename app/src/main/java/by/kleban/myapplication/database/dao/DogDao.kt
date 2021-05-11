package by.kleban.myapplication.database.dao

import androidx.room.*
import by.kleban.myapplication.database.entity.Dog

@Dao
interface DogDao {

    @Query("SELECT * FROM table_dog")
    suspend fun getAll(): List<Dog>

    @Insert
    suspend fun insertDog(dog: Dog)

    @Update
    suspend fun update(dog: Dog)

    @Query("DELETE FROM table_dog")
    suspend fun clear()

    @Delete
    suspend fun delete(dog: Dog)


}