package by.kleban.myapplication.homework3

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import by.kleban.myapplication.R


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

        val grodnoNumberPotato = findViewById<TextView>(R.id.txt_sowing_grodno_number_potato)
        val grodnoNumberBeet = findViewById<TextView>(R.id.txt_sowing_grodno_number_beet)
        val grodnoNumberCabbage = findViewById<TextView>(R.id.txt_sowing_grodno_number_cabbage)

        val gomelNumberPotato = findViewById<TextView>(R.id.txt_sowing_gomel_number_potato)
        val gomelNumberBeet = findViewById<TextView>(R.id.txt_sowing_gomel_number_beet)
        val gomelNumberCabbage = findViewById<TextView>(R.id.txt_sowing_gomel_number_cabbage)

        val mogilevNumberPotato = findViewById<TextView>(R.id.txt_sowing_mogilev_number_potato)
        val mogilevNumberBeet = findViewById<TextView>(R.id.txt_sowing_mogilev_number_beet)
        val mogilevNumberCabbage = findViewById<TextView>(R.id.txt_sowing_mogilev_number_cabbage)

        val textBrest = findViewById<TextView>(R.id.txt_sowing_brest_region)
        val textMinsk = findViewById<TextView>(R.id.txt_sowing_minsk_region)
        val textVitebsk = findViewById<TextView>(R.id.txt_sowing_vitebsk_region)
        val textGomel = findViewById<TextView>(R.id.txt_sowing_gomel_region)
        val textMogilev = findViewById<TextView>(R.id.txt_sowing_mogilev_region)
        val textGrodno = findViewById<TextView>(R.id.txt_sowing_grodno_region)

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

        viewModel.gomelRegion.observe(this) {
            gomelNumberPotato.text = it.areaOfPotato.toString()
            gomelNumberBeet.text = it.areaOfBeet.toString()
            gomelNumberCabbage.text = it.areaOfCabbage.toString()
        }

        viewModel.grodnoRegion.observe(this) {
            grodnoNumberPotato.text = it.areaOfPotato.toString()
            grodnoNumberBeet.text = it.areaOfBeet.toString()
            grodnoNumberCabbage.text = it.areaOfCabbage.toString()
        }

        viewModel.mogilevRegion.observe(this) {
            mogilevNumberPotato.text = it.areaOfPotato.toString()
            mogilevNumberBeet.text = it.areaOfBeet.toString()
            mogilevNumberCabbage.text = it.areaOfCabbage.toString()
        }

        viewModel.winners.observe(this) {
            it.map { it.name }.forEach { name ->
                val winnerTextView = when (name) {
                    "Brest" -> textBrest
                    "Minsk" -> textMinsk
                    "Vitebsk" -> textVitebsk
                    "Gomel" -> textGomel
                    "Grodno" -> textGrodno
                    "Mogilev" -> textMogilev
                    else -> throw Exception("Region did't find")
                }
                winnerTextView.setBackgroundColor(Color.GREEN)
            }
        }

        viewModel.plusAreaInHectares()
    }
}