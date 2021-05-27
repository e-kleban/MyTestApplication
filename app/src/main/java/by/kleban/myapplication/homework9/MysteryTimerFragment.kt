package by.kleban.myapplication.homework9

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kleban.myapplication.R


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

        viewModel.timerLiveData.observe(viewLifecycleOwner) {
            txtTimer.text = it.toString()
        }
        viewModel.startTimer()

        viewModel.adviceLiveData.observe(viewLifecycleOwner) { it ->
            if (it == null) {
                txtTimer.visibility = View.VISIBLE
            } else {
                txtTimer.visibility = View.GONE
                val intentService = Intent(requireContext(), MyForegroundService::class.java)
                intentService.putExtra(
                    MyForegroundService.EXTRA_STRING,
                    viewModel.adviceLiveData.value
                )
                requireActivity().startService(intentService)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.stopTimer()

    }
}