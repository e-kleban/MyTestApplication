package by.kleban.myapplication

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MysteryViewModel : ViewModel() {

    private val _timerLiveData = MutableLiveData<Int>(10)
    val timerLiveData: LiveData<Int>
        get() = _timerLiveData

    private val _isFinishedTimerLiveData = MutableLiveData<Boolean>(false)
    val isFinishedTimerLiveData: LiveData<Boolean>
        get() = _isFinishedTimerLiveData

    fun startTimer() {
        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timerLiveData.value = (millisUntilFinished.toInt().div(1000))
            }

            override fun onFinish() {
                _isFinishedTimerLiveData.value = true
            }
        }.start()
    }

}