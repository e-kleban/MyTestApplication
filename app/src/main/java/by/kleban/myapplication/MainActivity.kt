package by.kleban.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDz1 = findViewById<Button>(R.id.dz1)
        val buttonDz2 = findViewById<Button>(R.id.dz2)

        buttonDz1.setOnClickListener {
            startActivity(Intent(this, ImageUploadActivity::class.java))
        }

        buttonDz2.setOnClickListener {
            startActivity(Intent(this, FlagsAnimationActivity::class.java))
        }
    }
}