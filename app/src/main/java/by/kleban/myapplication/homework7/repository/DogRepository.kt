package by.kleban.myapplication.homework7.repository

import by.kleban.myapplication.homework7.database.MyDatabase
import by.kleban.myapplication.homework7.database.entity.Dog
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

    fun update(dog: Dog) {
        ioScope.launch {
            dogDao.update(dog)
        }
    }

    fun clear() {
        ioScope.launch {
            dogDao.clear()
        }
    }

    fun delete(breed: String){
        ioScope.launch {
            dogDao.delete(breed)
        }
    }


}