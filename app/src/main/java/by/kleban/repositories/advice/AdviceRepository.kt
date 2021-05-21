package by.kleban.repositories.advice

import by.kleban.networking.advice.AdviceServiceProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


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
