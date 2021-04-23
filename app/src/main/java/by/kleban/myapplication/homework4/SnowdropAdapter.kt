package by.kleban.myapplication.homework4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.R
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
            .load(snowdrop.ref).error(R.drawable.error_load_image)
            .into(holder.imgRef)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvKind: TextView = itemView.findViewById(R.id.txt_kind)
        val imgRef :ImageView= itemView.findViewById(R.id.img_ref)
        val tvDescription:TextView = itemView.findViewById(R.id.txt_description)
    }
}