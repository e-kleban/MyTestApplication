package by.kleban.myapplication.data.entities.currency



data class Crypto(
    val dateAdded: String,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val quote: Quote,
    val slug: String,
    val symbol: String,
) {
    data class Quote(
        val uSD:USD
    ) {
        data class USD(
            val lastUpdated: String,
            val marketCap: Double,
            val percentChange1h: Double,
            val percentChange24h: Double,
            val percentChange7d: Double,
            val price: Double,
            val volume24h: Double
        )
    }
}
//usd price  percent change 1h

//name symbol