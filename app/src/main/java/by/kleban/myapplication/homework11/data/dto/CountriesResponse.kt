package by.kleban.myapplication.homework11.data.dto


import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("countries")
    val countries: List<CountryResponse>?,
) {
    data class CountryResponse(
        @SerializedName("code")
        val countryCode: String?,
        @SerializedName("name")
        val countryName: String?,
    )

}