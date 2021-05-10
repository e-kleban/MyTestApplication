package by.kleban.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DogContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_container)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container__hw7_dog,  WelcomeDogCatalogFragment())
            .commit()
    }
}