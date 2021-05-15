package by.kleban.myapplication.homework8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kleban.myapplication.R


class WelcomeCryptoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome_crypto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonShow = view.findViewById<Button>(R.id.btn_show_crypto)
        buttonShow.setOnClickListener {
            findNavController().navigate(R.id.showCryptoCurrencyFragment)
        }

    }
}