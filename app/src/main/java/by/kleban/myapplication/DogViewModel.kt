package by.kleban.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.kleban.myapplication.database.MyDatabase
import by.kleban.myapplication.database.entity.Dog
import by.kleban.myapplication.repository.DogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async


class DogViewModel(application: Application) : AndroidViewModel(application) {

    private val dogRepository = DogRepository(MyDatabase.getDatabase(application))
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _dogListLiveData = MutableLiveData<List<Dog>>()
    val dogListLiveData: LiveData<List<Dog>>
        get() = _dogListLiveData

    fun loadAll() {
        ioScope.async {
            val dogList = dogRepository.getAll()
            _dogListLiveData.postValue(dogList)
        }

    }


}