package by.kleban.myapplication.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kleban.myapplication.R


class SnowdropStartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_snowdrop_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(SnowdropStartViewModel::class.java)
        val buttonAdd = view.findViewById<Button>(R.id.btn_add_snowdrop)
        val buttonShow = view.findViewById<Button>(R.id.btn_show_collection)

        buttonAdd.setOnClickListener {
            viewModel.changeScreen(Screen.ADD)
        }

        buttonShow.setOnClickListener {
            viewModel.changeScreen(Screen.SHOW)
        }
    }
}