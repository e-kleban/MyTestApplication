package by.kleban.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SnowdropStartViewModel : ViewModel() {

    val screenLiveData = MutableLiveData(Screen.START)

    fun changeScreen(screen: Screen) {
        screenLiveData.value = screen
    }
}