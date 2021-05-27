package by.kleban.myapplication.homework9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import by.kleban.myapplication.R


class WelcomeMysteryFragment : Fragment() {

    private lateinit var startButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mystery_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startButton = view.findViewById(R.id.btn_mystery_welcome)
        startButton.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.mystery_fragment_container, MysteryTimerFragment())
                .commit()
        }
    }
}