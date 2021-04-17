package by.kleban.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class BelarusSowingViewModel : ViewModel() {

    val brestRegion = MutableLiveData(Region("Brest", 0, 0, 0))
    val minskRegion = MutableLiveData(Region("Minsk", 0, 0, 0))
    val vitebskRegion = MutableLiveData(Region("Vitebsk", 0, 0, 0))
    val mogilevRegion = MutableLiveData(Region("Mogilev", 0, 0, 0))
    val gomelRegion = MutableLiveData(Region("Gomel", 0, 0, 0))
    val grodnoRegion = MutableLiveData(Region("Grodno", 0, 0, 0))

    val winners = MutableLiveData<List<Region>>()

    fun plusAreaInHectares() {
        viewModelScope.launch {
            while (true) {
                if (!winners.value.isNullOrEmpty()) {
                    break
                }
                delay(2000)
                val brest = brestRegion.value!!
                val minsk = minskRegion.value!!
                val vitebsk = vitebskRegion.value!!
                val grodno = grodnoRegion.value!!
                val gomel = gomelRegion.value!!
                val mogilev = mogilevRegion.value!!
                brestRegion.value = updateRegion(brest)
                minskRegion.value = updateRegion(minsk)
                vitebskRegion.value = updateRegion(vitebsk)
                grodnoRegion.value = updateRegion(grodno)
                gomelRegion.value = updateRegion(gomel)
                mogilevRegion.value = updateRegion(mogilev)
                winners.value = listOf(
                    brest,
                    minsk,
                    vitebsk,
                    mogilev,
                    grodno,
                    gomel
                ).filter { isWinner(it) }
            }
        }
    }

    private fun updateRegion(region: Region): Region {
        return region.apply {
            areaOfPotato += Random.nextInt(1, 150)
            areaOfBeet += Random.nextInt(1, 150)
            areaOfCabbage += Random.nextInt(1, 150)
        }
    }

    private fun isWinner(region: Region): Boolean {
        return region.areaOfBeet >= 1000
                && region.areaOfPotato >= 1000
                && region.areaOfCabbage >= 1000
    }
}