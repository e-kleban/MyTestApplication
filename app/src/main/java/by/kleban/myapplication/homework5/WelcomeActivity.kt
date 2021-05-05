package by.kleban.myapplication.homework5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.R

private const val EXTRA_NAME = "extra_name"

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val nameTextView = findViewById<TextView>(R.id.txt_welcome_name)
        val registeredName = intent.extras?.getString(EXTRA_NAME)
        nameTextView.text = registeredName
    }

    companion object {

        fun newIntent(context: Context, registeredName: String): Intent {
            val intent = Intent(context, WelcomeActivity::class.java)
            intent.putExtra(EXTRA_NAME, registeredName)
            return intent
        }

    }
}