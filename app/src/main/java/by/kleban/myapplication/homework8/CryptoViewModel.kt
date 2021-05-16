package by.kleban.myapplication.homework8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.kleban.myapplication.homework8.data.entities.currency.Crypto
import by.kleban.myapplication.homework8.repository.currency.CurrencyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CryptoViewModel : ViewModel() {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val cryptoRepository = CurrencyRepository()

    private val _cryptoListLiveData = MutableLiveData<List<Crypto.Data>>()
    val cryptoListLiveData: LiveData<List<Crypto.Data>> = _cryptoListLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoadingLiveData: LiveData<Boolean> = _isLoadingLiveData

    fun loadListOfCrypto() {
        _isLoadingLiveData.value = true
        ioScope.launch {
            try {
                _cryptoListLiveData.postValue(cryptoRepository.loadCrypto())
                _isLoadingLiveData.postValue(false)
            } catch (e: Exception) {
                _errorLiveData.postValue(e.message)
            }
        }
    }
}

