package by.kleban.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.database.entity.Dog
import com.squareup.picasso.Picasso


class DogsShowAdapter() :
    RecyclerView.Adapter<DogsShowAdapter.DogsShowViewHolder>() {

    val dogs = mutableListOf<Dog>()

    fun setItems(list: List<Dog>){
        dogs.clear()
        dogs.addAll(list)
        notifyDataSetChanged()
    }

    inner class DogsShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle = view.findViewById<TextView>(R.id.item_txt_dog_title)
        val textDescription = view.findViewById<TextView>(R.id.item_txt_dog_description)
        val imageDog = view.findViewById<ImageView>(R.id.item_img_dog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dog, parent, false)
        return DogsShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogsShowViewHolder, position: Int) {
        val dog = dogs[position]
        holder.textTitle.text = dog.breed
        holder.textDescription.text = dog.description
        Picasso.get()
            .load(dog.ref)
            .error(R.drawable.error_load_image)
            .into(holder.imageDog)
    }

    override fun getItemCount(): Int {
        return dogs.size
    }
}