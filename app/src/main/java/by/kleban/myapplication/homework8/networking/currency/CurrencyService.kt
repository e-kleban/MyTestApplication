package by.kleban.myapplication.homework8.networking.currency

import by.kleban.myapplication.homework8.data.dto.currency.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface CurrencyService {

    @Headers("X-CMC_PRO_API_KEY:b6cf6a55-b96d-43f3-a12f-50982ab560ba")
    @GET("v1/cryptocurrency/listings/latest")
    suspend fun loadCrypto(): Response<CryptoResponse>

}