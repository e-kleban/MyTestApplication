package by.kleban.myapplication.homework8.repository.currency

import by.kleban.myapplication.homework8.data.entities.currency.Crypto
import by.kleban.myapplication.homework8.mappers.currency.CryptoResponseMapper
import by.kleban.myapplication.homework8.networking.currency.CurrencyServiceProvider


class CurrencyRepository {

    private val currencyService = CurrencyServiceProvider.provideCurrencyService()
    private val cryptoResponseMapper = CryptoResponseMapper()

    suspend fun loadCrypto(): List<Crypto.Data> {
        val response = currencyService.loadCrypto()
        return if (response.isSuccessful) {
             response.body()
                ?.data
                ?.map { cryptoResponseMapper.map(it) }.orEmpty()
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }
}