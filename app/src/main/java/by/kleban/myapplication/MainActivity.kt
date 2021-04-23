package by.kleban.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.homework1.ImageUploadActivity
import by.kleban.myapplication.homework2.FlagsAnimationActivity
import by.kleban.myapplication.homework3.BelarusSowingActivity
import by.kleban.myapplication.homework4.SnowdropStartActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDz1 = findViewById<Button>(R.id.dz1)
        val buttonDz2 = findViewById<Button>(R.id.dz2)
        val buttonDz3 = findViewById<Button>(R.id.dz3)
        val buttonDz4 = findViewById<Button>(R.id.dz4)

        buttonDz1.setOnClickListener {
            val intent = Intent(this, ImageUploadActivity::class.java)
            startActivity(intent)
        }

        buttonDz2.setOnClickListener {
            val intent = Intent(this, FlagsAnimationActivity::class.java)
            startActivity(intent)
        }

        buttonDz3.setOnClickListener {
            val intent = Intent(this, BelarusSowingActivity::class.java)
            startActivity(intent)
        }

        buttonDz4.setOnClickListener {
        val intent = Intent(this, SnowdropStartActivity::class.java)
            startActivity(intent)
        }
    }
}