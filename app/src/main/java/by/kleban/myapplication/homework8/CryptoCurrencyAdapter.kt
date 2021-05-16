package by.kleban.myapplication.homework8

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.R
import by.kleban.myapplication.homework8.data.entities.currency.Crypto
import java.util.*


class CryptoCurrencyAdapter(private val context: Context) :
    RecyclerView.Adapter<CryptoCurrencyAdapter.CryptoCurrencyViewHolder>() {

    private val listOfCrypto = mutableListOf<Crypto.Data>()

    fun set(list: List<Crypto.Data>) {
        listOfCrypto.clear()
        listOfCrypto.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCurrencyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto, parent, false)
        return CryptoCurrencyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoCurrencyViewHolder, position: Int) {
        val crypto = listOfCrypto[position]
        val price = crypto.quote.uSD.price
        val oneHour = crypto.quote.uSD.percentChange1h
        setBackgroundTint(holder.iconText)
        holder.nameText.text = crypto.name
        holder.iconText.text = crypto.symbol
        holder.priceText.text = String.format("%.3f", price)
        holder.oneHourText.text = String.format("%.2f", oneHour)
    }

    override fun getItemCount(): Int {
        return listOfCrypto.size
    }

    private fun setBackgroundTint(textView: TextView) {
        val colorList = listOf(
            Color.RED,
            Color.CYAN,
            Color.GRAY,
            Color.GREEN,
            Color.BLUE,
            ContextCompat.getColor(context,R.color.blue_200)
        )
        val color = Random().nextInt(colorList.size)
        textView.background.setTint(colorList[color])
    }

    inner class CryptoCurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.item_name_crypto)
        val priceText: TextView = view.findViewById(R.id.item_price_crypto)
        val oneHourText: TextView = view.findViewById(R.id.item_one_hour_crypto)
        val iconText: TextView = view.findViewById(R.id.item_icon_crypto)
    }
}