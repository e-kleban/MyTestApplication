package by.kleban.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class BelarusSowingActivity : AppCompatActivity() {

    lateinit var viewModel: BelarusSowingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belarus_sowing)

        val brestNumberPotato = findViewById<TextView>(R.id.txt_sowing_brest_number_potato)
        val brestNumberBeet = findViewById<TextView>(R.id.txt_sowing_brest_number_beet)
        val brestNumberCabbage = findViewById<TextView>(R.id.txt_sowing_brest_number_cabbage)

        val minskNumberPotato = findViewById<TextView>(R.id.txt_sowing_minsk_number_potato)
        val minskNumberBeet = findViewById<TextView>(R.id.txt_sowing_minsk_number_beet)
        val minskNumberCabbage = findViewById<TextView>(R.id.txt_sowing_minsk_number_cabbage)

        val vitebskNumberPotato = findViewById<TextView>(R.id.txt_sowing_vitebsk_number_potato)
        val vitebskNumberBeet = findViewById<TextView>(R.id.txt_sowing_vitebsk_number_beet)
        val vitebskNumberCabbage = findViewById<TextView>(R.id.txt_sowing_vitebsk_number_cabbage)

        val textBrest = findViewById<TextView>(R.id.txt_sowing_brest_region)
        val textMinsk = findViewById<TextView>(R.id.txt_sowing_minsk_region)
        val textVitebsk = findViewById<TextView>(R.id.txt_sowing_vitebsk_region)

        viewModel = ViewModelProvider(this).get(BelarusSowingViewModel::class.java)

        viewModel.brestRegion.observe(this) {
            brestNumberPotato.text = it.areaOfPotato.toString()
            brestNumberBeet.text = it.areaOfBeet.toString()
            brestNumberCabbage.text = it.areaOfCabbage.toString()
        }

        viewModel.minskRegion.observe(this) {
            minskNumberPotato.text = it.areaOfPotato.toString()
            minskNumberBeet.text = it.areaOfBeet.toString()
            minskNumberCabbage.text = it.areaOfCabbage.toString()
        }

        viewModel.vitebskRegion.observe(this) {
            vitebskNumberPotato.text = it.areaOfPotato.toString()
            vitebskNumberBeet.text = it.areaOfBeet.toString()
            vitebskNumberCabbage.text = it.areaOfCabbage.toString()
        }

        viewModel.winners.observe(this) {
            it.map { it.name }.forEach { name ->
                val winnerTextView = when (name) {
                    "Brest" -> textBrest
                    "Minsk" -> textMinsk
                    "Vitebsk" -> textVitebsk
                    else -> throw Exception("Region did't find")
                }
                winnerTextView.setBackgroundColor(Color.GREEN)
            }
        }

        viewModel.plusAreaInHectares()
    }
}