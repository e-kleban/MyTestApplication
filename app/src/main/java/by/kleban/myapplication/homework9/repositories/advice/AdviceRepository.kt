package by.kleban.myapplication.homework9.repositories.advice

import by.kleban.myapplication.homework9.networking.advice.AdviceServiceProvider


class AdviceRepository {

    private val adviceService = AdviceServiceProvider.provideAdviceService()

    suspend fun loadAdvice(): String {
        val response = adviceService.loadAdvice()
        return if (response.isSuccessful) {
            response.body()
                ?.slip
                ?.advice
                .orEmpty()
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }
}
