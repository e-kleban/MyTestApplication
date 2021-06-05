package by.kleban.myapplication.homework11

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.R
import by.kleban.myapplication.homework11.adapter.CountryHolidayAdapter

class CountryHolidayActivity : AppCompatActivity() {

    private val countryHolidayViewModel by lazy {
        ViewModelProvider(this).get(CountryHolidayViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_holiday)

        val recycler = findViewById<RecyclerView>(R.id.recycler_country_holiday)
        recycler.layoutManager = LinearLayoutManager(this)

        val countryHolidayAdapter = CountryHolidayAdapter()
        recycler.adapter = countryHolidayAdapter

        countryHolidayViewModel.countryListLiveData.observe(this) {
            countryHolidayAdapter.set(it)
        }

        countryHolidayViewModel.updateCountryListLiveData.observe(this) {
            countryHolidayAdapter.updateItem(it)
        }

        countryHolidayViewModel.isLoadingCountryLiveData.observe(this) {
            findViewById<ProgressBar>(R.id.country_progress_bar).visibility = if (it == false) {
                View.GONE
            } else {
                View.VISIBLE
            }
        }

        countryHolidayViewModel.errorLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}