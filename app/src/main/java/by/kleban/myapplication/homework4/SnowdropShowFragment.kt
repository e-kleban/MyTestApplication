package by.kleban.myapplication.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.R


class SnowdropShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_snowdrop_show, container, false)

        val showRecyclerView = view.findViewById<RecyclerView>(R.id.snowdrop_show_recycler_view)
        showRecyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = SnowdropAdapter(requireContext())
        showRecyclerView.adapter = adapter

        val viewModel = ViewModelProvider(requireActivity()).get(SnowdropStartViewModel::class.java)
        viewModel.snowdropLiveData.observe(viewLifecycleOwner) { items ->
            if (!items.isNullOrEmpty()) {
                adapter.setItems(items)
            }
        }
        return view
    }
}