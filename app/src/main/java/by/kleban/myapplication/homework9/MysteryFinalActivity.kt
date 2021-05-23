package by.kleban.myapplication.homework9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.R


class MysteryFinalActivity : AppCompatActivity() {

    private lateinit var buttonHorror: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystery_final)

        buttonHorror = findViewById(R.id.btn_final)
        buttonHorror.setOnClickListener {
            val intent = Intent(this, MysteryContainerActivity::class.java)
            startActivity(intent)
        }
    }
}