package by.kleban.myapplication.repository.currency

import by.kleban.myapplication.data.entities.currency.Crypto
import by.kleban.myapplication.mappers.currency.CryptoResponseMapper
import by.kleban.myapplication.networking.currency.CurrencyServiceProvider


class CurrencyRepository {

    private val currencyService = CurrencyServiceProvider.provideCurrencyService()
    private val cryptoResponseMapper = CryptoResponseMapper()

    suspend fun loadCrypto(): List<Crypto> {
        val response = currencyService.loadCrypto()
        return if (response.isSuccessful) {
            response.body()?.map { cryptoResponse ->
                cryptoResponseMapper.map(cryptoResponse)
            }.orEmpty()
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }
}