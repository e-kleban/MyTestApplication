package by.kleban.myapplication.homework6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kleban.myapplication.R
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

        val textVictory = view.findViewById<TextView>(R.id.txt_welcome_name_day)

        textVictory.doOnPreDraw {
            YoYo.with(Techniques.Landing)
                .duration(1000)
                .pivot(textVictory.width / 2f, textVictory.height / 2f)
                .repeat(100)
                .playOn(view.findViewById(R.id.txt_welcome_name_day))
        }

        showButton = view.findViewById(R.id.btn_show_cards)
        showButton.setOnClickListener {
            findNavController().navigate(R.id.showCardsShowFragment)
        }
    }

}