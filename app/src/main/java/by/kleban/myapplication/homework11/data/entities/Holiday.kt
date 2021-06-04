package by.kleban.myapplication.homework11.data.entities

import com.google.gson.annotations.SerializedName


data class Holiday(
    @SerializedName("country")
    val countryCode: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("name")
    val name: String,
)
