package by.kleban.myapplication.homework11.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.R
import by.kleban.myapplication.homework11.data.entities.CountryWithHoliday


class CountryHolidayAdapter :
    RecyclerView.Adapter<CountryHolidayAdapter.CountryHolidayViewHolder>() {

    private val listCountryHoliday = mutableListOf<CountryWithHoliday>()

    fun set(list: List<CountryWithHoliday>) {
        listCountryHoliday.clear()
        listCountryHoliday.addAll(list)
        notifyDataSetChanged()
    }

    fun updateItem(item: CountryWithHoliday) {
        val oldItem = listCountryHoliday.find {
            it.countryCode == item.countryCode
        }
        val oldItemIndex = listCountryHoliday.indexOf(oldItem)
        listCountryHoliday[oldItemIndex] = item
        notifyItemChanged(oldItemIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolidayViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_county_holiday, parent, false)
        return CountryHolidayViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryHolidayViewHolder, position: Int) {
        holder.bind(listCountryHoliday[position])
    }

    override fun getItemCount(): Int {
        return listCountryHoliday.size
    }

    inner class CountryHolidayViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: CountryWithHoliday) {
            view.findViewById<TextView>(R.id.title_country).text = item.countryName
            if (item.holidayName != null && item.date != null) {
                val newDate = item.date?.replace("2020", "2021")
                view.findViewById<ProgressBar>(R.id.holiday_progress).visibility = View.GONE
                view.findViewById<TextView>(R.id.holiday_name_country).text = item.holidayName
                view.findViewById<TextView>(R.id.holiday_date_country).text = newDate

            }
        }
    }
}