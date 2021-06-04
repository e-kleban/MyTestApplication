package by.kleban.myapplication.homework11.mappers

import by.kleban.myapplication.homework11.data.dto.CountryHolidayResponse
import by.kleban.myapplication.homework11.data.entities.Holiday
import com.bignerdranch.android.a1305network.mappers.Mapper


class HolidayMapper : Mapper<CountryHolidayResponse.HolidayResponse, Holiday> {

    override fun map(from: CountryHolidayResponse.HolidayResponse): Holiday {
        return Holiday(
            countryCode = from.countryCode.orEmpty(),
            date = from.date.orEmpty(),
            name = from.name.orEmpty()
        )
    }
}