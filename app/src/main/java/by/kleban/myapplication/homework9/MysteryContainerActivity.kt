package by.kleban.myapplication.homework9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.R


class MysteryContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystery_container)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mystery_fragment_container, WelcomeMysteryFragment())
            .commit()
    }
}