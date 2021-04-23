package by.kleban.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserRegistrationViewModel : ViewModel() {

    private val _userNameData = MutableLiveData<String>()
    private val _passwordData = MutableLiveData<String>()
    private val _validationNameData = MutableLiveData<Validation>()
    private val _validationPasswordData = MutableLiveData<Validation>()


    val userNameData: LiveData<String>
        get() = _userNameData

    val passwordData: LiveData<String>
        get() = _passwordData

    fun changeName(name: String) {
        _userNameData.value = name
    }

    fun changePassword(password: String) {
        _passwordData.value = password
    }

    val validationNameData: LiveData<Validation>
        get() = _validationNameData

    val validationPasswordData: LiveData<Validation>
        get() = _validationPasswordData

    private fun validateName(): Validation {
        return when {
            _userNameData.value.isNullOrEmpty() -> Validation.EMPTY
            else -> Validation.VALID
        }
    }

    private fun validatePassword(): Validation {
        return when {
            _passwordData.value.isNullOrEmpty() -> Validation.EMPTY
            else -> Validation.VALID
        }
    }

    fun registration() {
        _validationNameData.value = validateName()
        _validationPasswordData.value = validatePassword()

    }
}