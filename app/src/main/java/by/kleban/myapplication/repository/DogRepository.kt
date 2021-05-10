package by.kleban.myapplication.repository

import by.kleban.myapplication.database.MyDatabase
import by.kleban.myapplication.database.entity.Dog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class DogRepository(
    private val myDatabase: MyDatabase
) {

    private val dogDao = myDatabase.dogDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    suspend fun getAll(): List<Dog> {
        return ioScope.async {
            dogDao.getAll()
        }.await()
    }

    suspend fun insertDog(dog: Dog) {
        ioScope.launch {
            dogDao.insertDog(dog)
        }
    }

    suspend fun update(dog: Dog) {
        ioScope.launch {
            dogDao.update(dog)
        }
    }


}