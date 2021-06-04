package by.kleban.myapplication.homework11.data.entities

import com.google.gson.annotations.SerializedName


data class Country(
    @SerializedName("code")
    val countryCode: String,
    @SerializedName("name")
    val name: String,
)