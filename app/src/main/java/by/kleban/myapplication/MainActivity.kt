package by.kleban.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.homework1.ImageUploadActivity
import by.kleban.myapplication.homework11.CountryHolidayActivity
import by.kleban.myapplication.homework2.FlagsAnimationActivity
import by.kleban.myapplication.homework3.BelarusSowingActivity
import by.kleban.myapplication.homework4.SnowdropStartActivity
import by.kleban.myapplication.homework5.UserRegistrationActivity
import by.kleban.myapplication.homework6.CongratulationContainerActivity
import by.kleban.myapplication.homework7.DogContainerActivity
import by.kleban.myapplication.homework8.ContainerHw8Activity
import by.kleban.myapplication.homework9.MysteryContainerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDz1 = findViewById<Button>(R.id.dz1)
        val buttonDz2 = findViewById<Button>(R.id.dz2)
        val buttonDz3 = findViewById<Button>(R.id.dz3)
        val buttonDz4 = findViewById<Button>(R.id.dz4)
        val buttonDz5 = findViewById<Button>(R.id.dz5)
        val buttonDz6 = findViewById<Button>(R.id.dz6)
        val buttonDz7 = findViewById<Button>(R.id.dz7)
        val buttonDz8 = findViewById<Button>(R.id.dz8)
        val buttonDz9 = findViewById<Button>(R.id.dz9)
        val buttonDz11 = findViewById<Button>(R.id.dz11)

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

        buttonDz5.setOnClickListener {
            val intent = Intent(this, UserRegistrationActivity::class.java)
            startActivity(intent)
        }

        buttonDz6.setOnClickListener {
            val intent = Intent(this, CongratulationContainerActivity::class.java)
            startActivity(intent)
        }

        buttonDz7.setOnClickListener {
            val intent = Intent(this, DogContainerActivity::class.java)
            startActivity(intent)
        }

        buttonDz8.setOnClickListener {
            val intent = Intent(this, ContainerHw8Activity::class.java)
            startActivity(intent)
        }

        buttonDz9.setOnClickListener {
            val intent = Intent(this, MysteryContainerActivity::class.java)
            startActivity(intent)
        }

        buttonDz11.setOnClickListener {
            val intent = Intent(this, CountryHolidayActivity::class.java)
            startActivity(intent)
        }
    }
}