package by.kleban.myapplication.homework7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import by.kleban.myapplication.R
import by.kleban.myapplication.homework7.database.entity.Dog
import com.squareup.picasso.Picasso


class OneDogFragment : Fragment() {

    companion object {
        const val PUT = "PUT"
    }

    private lateinit var textTitle: TextView
    private lateinit var imageDog: ImageView
    private lateinit var textDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one_dog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textTitle = view.findViewById(R.id.txt_title_dog_one)
        imageDog = view.findViewById(R.id.img_dog_one)
        textDescription = view.findViewById(R.id.description_dog_one)

        val dog = arguments?.getSerializable(PUT) as Dog

        textTitle.transitionName = "title${dog.breed}"
        imageDog.transitionName = "image${dog.breed}"
        textDescription.transitionName = "text${dog.breed}"

        textTitle.text = dog.breed
        textDescription.text = dog.description
        Picasso.get()
            .load(dog.ref)
            .error(R.drawable.error_load_image)
            .into(imageDog)
    }
}