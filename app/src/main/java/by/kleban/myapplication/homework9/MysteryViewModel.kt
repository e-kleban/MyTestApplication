package by.kleban.myapplication.homework9

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.kleban.myapplication.homework9.repositories.advice.AdviceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MysteryViewModel : ViewModel() {

    private lateinit var timer: CountDownTimer
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val adviceRepository = AdviceRepository()

    private val _timerLiveData = MutableLiveData<Int>(10)
    val timerLiveData: LiveData<Int>
        get() = _timerLiveData

    private val _isFinishedTimerLiveData = MutableLiveData<Boolean>(false)
    val isFinishedTimerLiveData: LiveData<Boolean>
        get() = _isFinishedTimerLiveData

    private val _adviceLiveData = MutableLiveData<String?>()
    val adviceLiveData: LiveData<String?>
        get() = _adviceLiveData

    fun startTimer() {
        _adviceLiveData.value = null
        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timerLiveData.value = (millisUntilFinished.toInt().div(1000))
                _isFinishedTimerLiveData.value = false
            }

            override fun onFinish() {
                _isFinishedTimerLiveData.value = true
                loadAdvice()
            }
        }.start()
    }

    fun stopTimer() {
        timer.cancel()
    }

    private fun loadAdvice() {
        ioScope.launch {
            try {
                _adviceLiveData.postValue(adviceRepository.loadAdvice())
            } catch (e: Exception) {
                _adviceLiveData.postValue(e.message)
            }
        }
    }
}