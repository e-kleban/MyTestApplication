package by.kleban.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CardShowAdapter(
    private val cardsList: MutableList<Card>,
    val listener: OnItemClickListener
) :
    RecyclerView.Adapter<CardShowAdapter.CardShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardShowViewHolder, position: Int) {
        holder.textCard.text = cardsList[position].congratulation
        Picasso.get()
            .load(cardsList[position].ref)
            .error(R.drawable.error_load_image)
            .into(holder.imageCard)
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }

    interface OnItemClickListener {
        fun onItemClick(card: Card)
    }

    inner class CardShowViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        val imageCard: ImageView = view.findViewById(R.id.item_img_card)
        val textCard: TextView = view.findViewById(R.id.item_text_card)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(cardsList[position])
            }
        }
    }
}