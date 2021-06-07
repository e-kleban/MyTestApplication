package by.kleban.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.databinding.ActivityMainBinding
import by.kleban.myapplication.homework1.ImageUploadActivity
import by.kleban.myapplication.homework11.CountryContainerActivity
import by.kleban.myapplication.homework2.FlagsAnimationActivity
import by.kleban.myapplication.homework3.BelarusSowingActivity
import by.kleban.myapplication.homework4.SnowdropStartActivity
import by.kleban.myapplication.homework5.UserRegistrationActivity
import by.kleban.myapplication.homework6.CongratulationContainerActivity
import by.kleban.myapplication.homework7.DogContainerActivity
import by.kleban.myapplication.homework8.ContainerHw8Activity
import by.kleban.myapplication.homework9.MysteryContainerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.dz1.setOnClickListener {
            val intent = Intent(this, ImageUploadActivity::class.java)
            startActivity(intent)
        }

        binding.dz2.setOnClickListener {
            val intent = Intent(this, FlagsAnimationActivity::class.java)
            startActivity(intent)
        }

        binding.dz3.setOnClickListener {
            val intent = Intent(this, BelarusSowingActivity::class.java)
            startActivity(intent)
        }

        binding.dz4.setOnClickListener {
            val intent = Intent(this, SnowdropStartActivity::class.java)
            startActivity(intent)
        }

        binding.dz5.setOnClickListener {
            val intent = Intent(this, UserRegistrationActivity::class.java)
            startActivity(intent)
        }

        binding.dz6.setOnClickListener {
            val intent = Intent(this, CongratulationContainerActivity::class.java)
            startActivity(intent)
        }

        binding.dz7.setOnClickListener {
            val intent = Intent(this, DogContainerActivity::class.java)
            startActivity(intent)
        }

        binding.dz8.setOnClickListener {
            val intent = Intent(this, ContainerHw8Activity::class.java)
            startActivity(intent)
        }

        binding.dz9.setOnClickListener {
            val intent = Intent(this, MysteryContainerActivity::class.java)
            startActivity(intent)
        }

        binding.dz11.setOnClickListener {
            val intent = Intent(this, CountryContainerActivity::class.java)
            startActivity(intent)
        }
    }
}