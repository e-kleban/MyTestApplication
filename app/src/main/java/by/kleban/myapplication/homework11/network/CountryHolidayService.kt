package by.kleban.myapplication.homework11.network

import by.kleban.myapplication.homework11.data.dto.CountriesResponse
import by.kleban.myapplication.homework11.data.dto.CountryHolidayResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface CountryHolidayService {

    @GET("v1/countries?pretty&key=553055ba-3754-4853-990f-6077b1d0ea77")
    fun loadCountries(): Single<CountriesResponse>

    @GET("v1/holidays?pretty&key=553055ba-3754-4853-990f-6077b1d0ea77&year=2020&upcoming=true&")
    fun loadHoliday(
        @Query("country")
        country: String,
        @Query("month")
        month: Int,
        @Query("day")
        day: Int,
    ): Single<CountryHolidayResponse>
}