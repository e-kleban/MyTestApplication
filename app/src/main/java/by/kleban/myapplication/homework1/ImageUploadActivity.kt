package by.kleban.myapplication.homework1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kleban.myapplication.R
import com.squareup.picasso.Picasso


class ImageUploadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_upload)

        val buttonClick = findViewById<Button>(R.id.button_upload)
        val inputField = findViewById<EditText>(R.id.edt_image_input)
        val imageView = findViewById<ImageView>(R.id.imv_image)

        buttonClick.setOnClickListener {
            if (inputField.text.isNullOrEmpty()) {
                Toast.makeText(this, "Поле для ввода пустое.\nВведите ссылку.", Toast.LENGTH_LONG)
                    .show()
            } else {
                Picasso.get()
                    .load(inputField.text.toString())
                    .into(imageView)
                inputField.text.clear()
            }
        }
    }
}