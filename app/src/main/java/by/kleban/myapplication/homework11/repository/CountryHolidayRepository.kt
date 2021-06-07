package by.kleban.myapplication.homework11.repository

import by.kleban.myapplication.homework11.data.entities.Country
import by.kleban.myapplication.homework11.data.entities.Holiday
import by.kleban.myapplication.homework11.mappers.CountryMapper
import by.kleban.myapplication.homework11.mappers.HolidayMapper
import by.kleban.myapplication.homework11.network.CountryHolidayServiceProvider
import io.reactivex.rxjava3.core.Single


class CountryHolidayRepository {

    private val countryHolidayService = CountryHolidayServiceProvider.provideCountryHolidayService()
    private val countryMapper = CountryMapper()
    private val holidayMapper = HolidayMapper()

    fun loadCountries(): Single<List<Country>> {
        return countryHolidayService.loadCountries()
            .flattenAsObservable { it.countries }
            .map { countryMapper.map(it) }
            .toList()
    }


    fun loadHoliday(countryCode: String, month: Int, day: Int): Single<List<Holiday>> {
        return countryHolidayService.loadHoliday(countryCode, month, day)
            .flattenAsObservable { it.holidays }
            .map { holidayMapper.map(it) }
            .toList()
    }
}