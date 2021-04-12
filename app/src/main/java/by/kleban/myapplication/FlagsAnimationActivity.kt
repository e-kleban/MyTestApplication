package by.kleban.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class FlagsAnimationActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags_animation)

        val buttonAnimation = findViewById<Button>(R.id.btn_animation)
        buttonAnimation.setOnClickListener {
            val intent = Intent(this, CatAnimationActivity::class.java)
            startActivity(intent)
        }
    }
}