package by.kleban.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MysteryContainerActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystery_container)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mystery_fragment_container,WelcomeMysteryFragment())
            .commit()
    }
}