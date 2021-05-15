package by.kleban.myapplication.homework8.mappers.currency

import by.kleban.myapplication.homework8.data.dto.currency.CryptoResponse
import by.kleban.myapplication.homework8.data.entities.currency.Crypto
import com.bignerdranch.android.a1305network.mappers.Mapper


class CryptoResponseMapper : Mapper<CryptoResponse.Data, Crypto.Data> {

    override fun map(from: CryptoResponse.Data): Crypto.Data {
        return Crypto.Data(
            dateAdded = from.dateAdded.orEmpty(),
            id = from.id ?: -1,
            lastUpdated = from.lastUpdated.orEmpty(),
            name = from.name.orEmpty(),
            quote = mapQuote(from.quote),
            slug = from.slug.orEmpty(),
            symbol = from.symbol.orEmpty()
        )
    }

    private fun mapQuote(from: CryptoResponse.Data.Quote?): Crypto.Data.Quote {
        return Crypto.Data.Quote(
            uSD = mapUSD(from?.uSD)
        )
    }

    private fun mapUSD(from: CryptoResponse.Data.Quote.USD?): Crypto.Data.Quote.USD {
        return Crypto.Data.Quote.USD(
            lastUpdated = from?.lastUpdated.orEmpty(),
            marketCap = from?.marketCap ?: 0.0,
            percentChange1h = from?.percentChange1h ?: 0.0,
            percentChange24h = from?.percentChange24h ?: 0.0,
            percentChange7d = from?.percentChange7d ?: 0.0,
            price = from?.price ?: 0.0,
            volume24h = from?.volume24h ?: 0.0
        )
    }


}