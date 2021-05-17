package by.kleban.myapplication.homework8.data.dto.currency


import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("status")
    val status: Status
) {
    data class Data(
        @SerializedName("date_added")
        val dateAdded: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("last_updated")
        val lastUpdated: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("platform")
        val platform: Any?,
        @SerializedName("quote")
        val quote: Quote?,
        @SerializedName("slug")
        val slug: String?,
        @SerializedName("symbol")
        val symbol: String?,
        @SerializedName("tags")
        val tags: List<String?>?,
    ) {
        data class Quote(
            @SerializedName("USD")
            val uSD: USD?
        ) {
            data class USD(
                @SerializedName("last_updated")
                val lastUpdated: String?,
                @SerializedName("market_cap")
                val marketCap: Double?,
                @SerializedName("percent_change_1h")
                val percentChange1h: Double?,
                @SerializedName("percent_change_24h")
                val percentChange24h: Double?,
                @SerializedName("percent_change_30d")
                val percentChange30d: Double?,
                @SerializedName("percent_change_60d")
                val percentChange60d: Double?,
                @SerializedName("percent_change_7d")
                val percentChange7d: Double?,
                @SerializedName("percent_change_90d")
                val percentChange90d: Double?,
                @SerializedName("price")
                val price: Double?,
                @SerializedName("volume_24h")
                val volume24h: Double?
            )
        }
    }

    data class Status(
        @SerializedName("credit_count")
        val creditCount: Int?,
        @SerializedName("elapsed")
        val elapsed: Int?,
        @SerializedName("error_code")
        val errorCode: Int?,
        @SerializedName("error_message")
        val errorMessage: Any?,
        @SerializedName("notice")
        val notice: Any?,
        @SerializedName("timestamp")
        val timestamp: String?,
        @SerializedName("total_count")
        val totalCount: Int?
    )
}