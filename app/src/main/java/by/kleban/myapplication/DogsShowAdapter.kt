package by.kleban.myapplication

import android.icu.text.Transliterator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.RecyclerView
import by.kleban.myapplication.database.entity.Dog
import by.kleban.myapplication.homework6.Card
import com.squareup.picasso.Picasso


class DogsShowAdapter(val listener: OnItemClickListener) :
    RecyclerView.Adapter<DogsShowAdapter.DogsShowViewHolder>() {

    val dogs = mutableListOf<Dog>()

    fun setItems(list: List<Dog>){
        dogs.clear()
        dogs.addAll(list)
        notifyDataSetChanged()
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

        holder.textTitle.transitionName="title${dog.breed}"
        holder.imageDog.transitionName="image${dog.breed}"
        holder.textDescription.transitionName="text${dog.breed}"
    }

    override fun getItemCount(): Int {
        return dogs.size
    }

    interface OnItemClickListener {
        fun onItemClick(dog: Dog)
    }

    inner class DogsShowViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val textTitle = view.findViewById<TextView>(R.id.item_txt_dog_title)
        val textDescription = view.findViewById<TextView>(R.id.item_txt_dog_description)
        val imageDog = view.findViewById<ImageView>(R.id.item_img_dog)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onItemClick(dogs[position])
            }
        }
    }
}