package by.kleban.myapplication.homework11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kleban.myapplication.R
import by.kleban.myapplication.databinding.FragmentCountryWelcomeBinding


class CountryWelcomeFragment : Fragment() {

    private var _binding: FragmentCountryWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnShowCountries.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.country_fragment_container, CountryHolidayFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}