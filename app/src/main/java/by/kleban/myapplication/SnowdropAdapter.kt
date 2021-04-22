package by.kleban.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class SnowdropAdapter(context: Context) : RecyclerView.Adapter<SnowdropAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private val items = mutableListOf<Snowdrop>()

    fun setItems(newItems: List<Snowdrop>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.list_item_snowdrop, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val snowdrop = items[position]
        holder.tvKind.text = snowdrop.kind
        holder.tvDescription.text=snowdrop.description
        Picasso.get()
            .load(snowdrop.ref)
            .into(holder.imgRef)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvKind = itemView.findViewById<TextView>(R.id.txt_kind)
        val imgRef = itemView.findViewById<ImageView>(R.id.img_ref)
        val tvDescription = itemView.findViewById<TextView>(R.id.txt_description)
    }
}