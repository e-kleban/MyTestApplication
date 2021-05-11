package by.kleban.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.database.entity.Dog


class ShowDogsFragment : Fragment(), DogsShowAdapter.OnItemClickListener {

    private lateinit var listOfDog: List<Dog>

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(DogViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_dogs, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadAll()

        val toolbar = view.findViewById<Toolbar>(R.id.tool_bar)
        val edtSearch = view.findViewById<EditText>(R.id.search_input_text)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_dog)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        val myAdapter = DogsShowAdapter(this)
        recycler.adapter = myAdapter

        viewModel.dogListLiveData.observe(viewLifecycleOwner) {
            Log.d("123", "${it.toString()}")
            myAdapter.setItems(it)
        }

        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.addDog -> {
                    AddDogDialogFragment().show(
                        requireActivity().supportFragmentManager,
                        AddDogDialogFragment.TAG
                    )
                    true
                }
                R.id.search -> {
                    if (edtSearch.visibility == View.GONE) {
                        menuItem.setIcon(R.drawable.ic_baseline_done_24)
                        edtSearch.visibility = View.VISIBLE
                        edtSearch.doAfterTextChanged { Editable ->
                            viewModel.select(Editable.toString())
                            viewModel.dogListWithFilter.observe(viewLifecycleOwner) { list ->
                                myAdapter.setItems(list)
                            }
                        }
                    } else if (edtSearch.visibility == View.VISIBLE) {
                        menuItem.setIcon(R.drawable.ic_baseline_search_24)
                        edtSearch.visibility = View.GONE
                    }
                    true
                }
                else -> false
            }
        }
    }

    override fun onItemClick(dog: Dog) {
        val bundle = Bundle().apply {
            putSerializable(OneDogFragment.PUT, dog)
        }
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container__hw7_dog, OneDogFragment::class.java, bundle)
            .addToBackStack(null)
            .commit()
    }
}
