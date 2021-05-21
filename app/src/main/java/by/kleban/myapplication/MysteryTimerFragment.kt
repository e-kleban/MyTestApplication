package by.kleban.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


class MysteryTimerFragment : Fragment() {

    private lateinit var txtTimer: TextView
    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(MysteryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mystery_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtTimer = view.findViewById(R.id.txt_mystery_timer)

        viewModel.timerLiveData.observe(requireActivity()) {
            txtTimer.text = it.toString()
        }

        viewModel.isFinishedTimerLiveData.observe(requireActivity()) {
            if (it==false) {
                txtTimer.visibility = View.VISIBLE
            } else {
                txtTimer.visibility = View.GONE
            }
        }

        viewModel.startTimer()
    }

    override fun onStop() {
        super.onStop()
        viewModel.stopTimer()

    }
}