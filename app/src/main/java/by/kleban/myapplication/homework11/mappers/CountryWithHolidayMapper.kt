package by.kleban.myapplication.homework11.mappers

import by.kleban.myapplication.homework11.data.entities.Country
import by.kleban.myapplication.homework11.data.entities.CountryWithHoliday
import com.bignerdranch.android.a1305network.mappers.Mapper


class CountryWithHolidayMapper : Mapper<Country, CountryWithHoliday> {

    override fun map(from: Country): CountryWithHoliday {
        return CountryWithHoliday(
            countryCode = from.countryCode,
            countryName = from.countryName
        )
    }
}