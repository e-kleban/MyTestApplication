package by.kleban.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo


class WelcomeFragment : Fragment() {
    lateinit var showButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        YoYo.with(Techniques.FlipInX)
            .duration(1000)
            .repeat(100)
            .playOn(view.findViewById(R.id.txt_welcome_name_day))

        showButton = view.findViewById(R.id.btn_show_cards)
        showButton.setOnClickListener {
            findNavController().navigate(R.id.showCardsShowFragment)
        }
    }

}