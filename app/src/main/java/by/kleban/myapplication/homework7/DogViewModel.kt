package by.kleban.myapplication.homework7

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.kleban.myapplication.homework7.database.MyDatabase
import by.kleban.myapplication.homework7.database.entity.Dog
import by.kleban.myapplication.homework7.repository.DogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DogViewModel(application: Application) : AndroidViewModel(application) {

    private val dogRepository = DogRepository(MyDatabase.getDatabase(application))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _dogListLiveData = MutableLiveData<List<Dog>>()
    val dogListLiveData: LiveData<List<Dog>>
        get() = _dogListLiveData

    private val _dogListWithFilter = MutableLiveData<List<Dog>>()
    val dogListWithFilter: LiveData<List<Dog>>
        get() = _dogListWithFilter

    fun loadAll() {
        ioScope.launch {
            val dogList = dogRepository.getAll()
            _dogListLiveData.postValue(dogList)
        }
    }

    fun addDog(dog: Dog) {
        ioScope.launch {
            dogRepository.insertDog(dog)
            _dogListLiveData.postValue(dogRepository.getAll())
        }
    }

    fun clear() {
        dogRepository.clear()
    }

    fun select(string: String) {
        _dogListWithFilter.value = _dogListLiveData.value?.filter {
            it.breed.startsWith(string, true)
        }
    }

    fun delete(breed: String) {
        ioScope.launch {
            dogRepository.delete(breed)
            _dogListLiveData.postValue(dogRepository.getAll())
        }
    }
}