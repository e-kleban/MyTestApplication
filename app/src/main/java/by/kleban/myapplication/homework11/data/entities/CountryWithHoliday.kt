package by.kleban.myapplication.homework11.data.entities


data class CountryWithHoliday(
    val countryCode: String,
    val countryName: String,
    var holidayName: String? = null,
    var date: String? = null,
)

