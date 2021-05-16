package by.kleban.myapplication.homework8

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.R


class CryptoCurrencyFragment : Fragment() {

    private val cryptoViewModel by lazy {
        ViewModelProvider(requireActivity()).get(CryptoViewModel::class.java)
    }
    private lateinit var cryptoCurrencyAdapter: CryptoCurrencyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crypto_currency, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_crypto_currency)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        cryptoCurrencyAdapter = CryptoCurrencyAdapter(requireContext())
        recycler.adapter = cryptoCurrencyAdapter

        cryptoViewModel.cryptoListLiveData.observe(requireActivity()) {
            cryptoCurrencyAdapter.set(it)
        }
        cryptoViewModel.errorLiveData.observe(requireActivity()) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        cryptoViewModel.loadListOfCrypto()

        view.findViewById<Toolbar>(R.id.tool_bar_crypto).setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}