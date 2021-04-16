package by.kleban.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class BelarusSowingViewModel : ViewModel() {

    val brestRegion = MutableLiveData<Region>(Region("Brest", 0, 0, 0))
    val minskRegion = MutableLiveData<Region>(Region("Minsk", 0, 0, 0))
    val vitebskRegion = MutableLiveData<Region>(Region("Vitebsk", 0, 0, 0))
    val winners = MutableLiveData<List<Region>>()

    fun plusAreaInHectares() {
        viewModelScope.launch {
            while (true) {
                delay(2000)
                val brest = brestRegion.value!!
                val minsk = minskRegion.value!!
                val vitebsk = vitebskRegion.value!!
                brestRegion.value = updateRegion(brest)
                minskRegion.value = updateRegion(minsk)
                vitebskRegion.value = updateRegion(vitebsk)
                winners.value = listOf(brest, minsk, vitebsk).filter { isWinner(it) }
                if (!winners.value.isNullOrEmpty()){
                    break
                }
            }
        }
    }

    private fun updateRegion(region: Region): Region {
        return region.apply {
            areaOfPotato += Random.nextInt(10, 250)
            areaOfBeet += Random.nextInt(10, 250)
            areaOfCabbage += Random.nextInt(10, 250)
        }
    }

    private fun isWinner(region: Region): Boolean {
        return region.areaOfBeet >= 1000 && region.areaOfPotato >= 1000 && region.areaOfCabbage >= 1000
    }
}