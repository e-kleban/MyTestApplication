package by.kleban.myapplication.homework7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.R


class DogContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_container)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container__hw7_dog, WelcomeDogCatalogFragment())
            .commit()
    }
}