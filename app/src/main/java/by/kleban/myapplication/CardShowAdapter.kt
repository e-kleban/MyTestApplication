package by.kleban.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CardShowAdapter(
    private val cardsList: MutableList<Card>,
    val listener: OnItemClickListener,
) :
    RecyclerView.Adapter<CardShowAdapter.CardShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardShowViewHolder, position: Int) {
        val card = cardsList[position]
        holder.textCard.text = card.congratulation
        Picasso.get()
            .load(card.ref)
            .error(R.drawable.error_load_image)
            .into(holder.imageCard)

        holder.imageCard.transitionName = "image${card.ref}"
        holder.textCard.transitionName = "text${card.ref}"
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }

    interface OnItemClickListener {
        fun onItemClick(card: Card, extras: FragmentNavigator.Extras)
    }

    inner class CardShowViewHolder(view: View) : RecyclerView.ViewHolder(view.rootView),
        View.OnClickListener {

        val imageCard: ImageView = view.findViewById(R.id.item_img_card)
        val textCard: TextView = view.findViewById(R.id.item_text_card)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val extras = FragmentNavigatorExtras(
                    Pair(imageCard, imageCard.transitionName),
                    Pair(textCard, textCard.transitionName)
                )
                listener.onItemClick(cardsList[position], extras)
            }
        }
    }
}