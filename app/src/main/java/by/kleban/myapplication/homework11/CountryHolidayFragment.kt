package by.kleban.myapplication.homework11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kleban.myapplication.databinding.FragmentCountryHolidayBinding
import by.kleban.myapplication.homework11.adapter.CountryHolidayAdapter

class CountryHolidayFragment : Fragment() {

    private val countryHolidayViewModel by lazy {
        ViewModelProvider(this).get(CountryHolidayViewModel::class.java)
    }

    private var _binding: FragmentCountryHolidayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryHolidayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = binding.recyclerCountryHoliday
        recycler.layoutManager = LinearLayoutManager(requireContext())

        val countryHolidayAdapter = CountryHolidayAdapter()
        recycler.adapter = countryHolidayAdapter

        countryHolidayViewModel.countryListLiveData.observe(viewLifecycleOwner) {
            countryHolidayAdapter.set(it)
        }

        countryHolidayViewModel.updateCountryListLiveData.observe(viewLifecycleOwner) {
            countryHolidayAdapter.updateItem(it)
        }

        countryHolidayViewModel.isLoadingCountryLiveData.observe(viewLifecycleOwner) {
            binding.countryProgressBar.visibility =
                if (it == false) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
        }

        countryHolidayViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
}