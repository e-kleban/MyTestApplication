package by.kleban.myapplication.homework11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.R


class CountryContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_container)

        supportFragmentManager.beginTransaction()
            .replace(R.id.country_fragment_container, CountryWelcomeFragment())
            .commit()
    }
}