package by.kleban.myapplication.homework11.mappers

import by.kleban.myapplication.homework11.data.dto.CountriesResponse
import by.kleban.myapplication.homework11.data.entities.Country
import com.bignerdranch.android.a1305network.mappers.Mapper


class CountryMapper : Mapper<CountriesResponse.CountryResponse, Country> {

    override fun map(from: CountriesResponse.CountryResponse): Country {
        return Country(
            code = from.code.orEmpty(),
            name = from.name.orEmpty()
        )
    }
}