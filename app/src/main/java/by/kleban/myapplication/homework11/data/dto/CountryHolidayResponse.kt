package by.kleban.myapplication.homework11.data.dto


import com.google.gson.annotations.SerializedName

data class CountryHolidayResponse(
    @SerializedName("holidays")
    val holidays: List<HolidayResponse>?,
) {
    data class HolidayResponse(
        @SerializedName("country")
        val countryCode: String?,
        @SerializedName("date")
        val date: String?,
        @SerializedName("name")
        val name: String?,
    )
}