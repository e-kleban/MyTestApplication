package by.kleban.myapplication

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception


class OneCardFragment : Fragment() {

    private lateinit var card: Card
    private lateinit var oneText: TextView
    private lateinit var oneImage: ImageView

    companion object {
        const val PUT = "put"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        oneText = view.findViewById(R.id.one_text)
        oneImage = view.findViewById(R.id.one_image)

        card = arguments?.getSerializable(PUT) as Card
        oneImage.transitionName = "image${card.ref}"
        oneText.transitionName = "text${card.ref}"
        oneText.text = card.congratulation
        Picasso.get()
            .load(card.ref)
            .error(R.drawable.error_load_image)
            .into(oneImage)
    }
}