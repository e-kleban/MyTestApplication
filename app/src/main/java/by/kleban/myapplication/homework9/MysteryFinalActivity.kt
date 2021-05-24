package by.kleban.myapplication.homework9

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.R


class MysteryFinalActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FINAL_STRING = "extra final string"
    }

    private lateinit var buttonHorror: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystery_final)

        val advice = intent.extras?.getString(EXTRA_FINAL_STRING)
        Toast.makeText(this, advice, Toast.LENGTH_SHORT)
            .apply { setGravity(Gravity.TOP, 0, 100) }
            .show()

        buttonHorror = findViewById(R.id.btn_final)
        buttonHorror.setOnClickListener {
            val intent = Intent(this, MysteryContainerActivity::class.java)
            startActivity(intent)
        }
    }
}