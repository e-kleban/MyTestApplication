package by.kleban.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.kleban.myapplication.data.entities.currency.Crypto
import by.kleban.myapplication.repository.currency.CurrencyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CryptoViewModel : ViewModel() {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val cryptoRepository = CurrencyRepository()

    private val _cryptoListLiveData = MutableLiveData<List<Crypto>>()
    val cryptoListLiveData: LiveData<List<Crypto>> = _cryptoListLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    fun loadListOfCrypto() {
        ioScope.launch {
            try {
                _cryptoListLiveData.postValue(cryptoRepository.loadCrypto())
            } catch (e: Exception) {
                _errorLiveData.postValue(e.message)
            }
        }
    }

}