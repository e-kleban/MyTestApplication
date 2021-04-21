package by.kleban.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SnowdropStartViewModel : ViewModel() {

    val screenLiveData = MutableLiveData(Screen.START)
    val snowdropLiveData = MutableLiveData<MutableList<Snowdrop>>(mutableListOf())

    fun changeScreen(screen: Screen) {
        screenLiveData.value = screen
    }

    fun addSnowdrop(snowdrop: Snowdrop) {
        val snowdrops = snowdropLiveData.value ?: mutableListOf()
        snowdrops.add(snowdrop)
        snowdropLiveData.value = snowdrops
    }
}