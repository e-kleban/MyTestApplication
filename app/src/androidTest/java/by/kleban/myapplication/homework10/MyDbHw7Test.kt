package by.kleban.myapplication.homework10

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import by.kleban.myapplication.homework7.database.MyDatabase
import by.kleban.myapplication.homework7.database.dao.DogDao
import by.kleban.myapplication.homework7.database.entity.Dog
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class MyDbHw7Test {

    private lateinit var dogDao: DogDao

    @Before
    fun init() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val dogDb = Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dogDao = dogDb.dogDao()
    }

    @Test
    fun insertDog_returnTrue() {
        val dog1 = Dog("Poodle", "https/.....1", "Good breed for game and happy life")

        runBlocking {
            dogDao.insertDog(dog1)
            val dogList = dogDao.getAll()
            Truth.assertThat(dogList.contains(dog1)).isTrue()
        }
    }

    @Test
    fun deleteDog_returnTrue() {
        val dog1 = Dog("Poodle", "https/.....1", "Good breed for game and happy life")
        val breedDog1 = dog1.breed

        runBlocking {
            dogDao.insertDog(dog1)
            dogDao.delete(breedDog1)
            val dogList = dogDao.getAll()
            Truth.assertThat(dogList).doesNotContain(dog1)
        }
    }

    @Test
    fun getAllDogs_returnTrue() {
        val dog1 = Dog("Poodle", "https/.....1", "Good breed for game and happy life")
        val dog2 = Dog("Terrier", "https/.....2", "Good breed for badger, otter hunting")
        val dog3 = Dog("Akita", "https/.....3", "Good breed for hunting bears")
        val dog4 = Dog("Husky", "https/.....4", "Good breed for sled pulling")

        val list = listOf(dog1, dog2, dog3, dog4)

        runBlocking {
            dogDao.insertDog(dog1)
            dogDao.insertDog(dog2)
//            dogDao.insertDog(dog3)
            dogDao.insertDog(dog4)
            val listDb = dogDao.getAll()

            Truth.assertThat(listDb).isEqualTo(list)
        }
    }

    @Test
    fun updateDog() {
        val dog1 = Dog(
            breed = "Poodle",
            ref = "https/.....1",
            description = "Good breed for game and happy life",
        )

        runBlocking {
            dogDao.insertDog(dog1)
            val listDogDb = dogDao.getAll()
            val dog1Id = dogDao.getAll().first().id

            val updateDog = Dog(
                breed = "Update Poodle",
                ref = "https/.....123",
                description = "The best dog"
            )
            updateDog.id = dog1Id
            dogDao.update(updateDog)
            val updateDogListDb = dogDao.getAll()
            Truth.assertThat(updateDogListDb).isNotEqualTo(listDogDb)
        }
    }
}