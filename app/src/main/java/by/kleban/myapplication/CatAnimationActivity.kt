package by.kleban.myapplication

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class CatAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_animation)

        val catImage = findViewById<ImageView>(R.id.img_cat_animation)
        catImage.setImageResource(R.drawable.animation_cat)
        val catAnimation = catImage.drawable as AnimationDrawable
        catAnimation.start()
    }
}