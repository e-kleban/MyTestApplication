package by.kleban.myapplication.homework6

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.R

class CardsShowFragment : Fragment(), CardShowAdapter.OnItemClickListener {

    private lateinit var cardsList: MutableList<Card>
    private val viewModel by lazy {
        ViewModelProvider(this).get(CardsShowViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cards_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showCardsRecycles = view.findViewById<RecyclerView>(R.id.cards_recycler)
        showCardsRecycles.layoutManager = LinearLayoutManager(requireContext())

        viewModel.listCardsLiveData.observe(viewLifecycleOwner) { card ->
            cardsList = card
            val adapter = CardShowAdapter(cardsList, this)
            showCardsRecycles.adapter = adapter
        }
    }

    override fun onItemClick(card: Card, extras: FragmentNavigator.Extras) {
        val bundle = Bundle().apply {
            putSerializable(OneCardFragment.PUT, card)
        }
        findNavController().navigate(R.id.showOneCardFragment, bundle, null, extras)
    }
}