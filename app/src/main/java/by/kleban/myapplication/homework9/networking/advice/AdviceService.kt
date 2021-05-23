package by.kleban.myapplication.homework9.networking.advice

import by.kleban.myapplication.homework9.data.dto.advice.AdviceResponse
import retrofit2.Response
import retrofit2.http.GET


interface AdviceService {

    @GET("advice")
    suspend fun loadAdvice(): Response<AdviceResponse>
}