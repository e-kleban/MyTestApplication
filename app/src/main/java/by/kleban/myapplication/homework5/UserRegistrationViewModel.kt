package by.kleban.myapplication.homework5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserRegistrationViewModel : ViewModel() {

    private val _userNameData = MutableLiveData<String>()
    private val _passwordData = MutableLiveData<String>()
    private val _validationNameData = MutableLiveData<Validation>()
    private val _validationPasswordData = MutableLiveData<Validation>()
    private val _registrationData = MutableLiveData<Registration>()


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

    val registrationData: LiveData<Registration>
        get() = _registrationData

    private fun validateName(): Validation {
        return when {
            _userNameData.value.isNullOrEmpty() -> Validation.EMPTY
            else -> Validation.VALID
        }
    }

    private fun validatePassword(): Validation {
        return when {
            _passwordData.value.isNullOrEmpty() -> Validation.EMPTY
            _passwordData.value?.length ?: 0 > 8 -> Validation.TOO_MANY_SYMBOLS
            else -> Validation.VALID
        }
    }

    fun registration() {
        _validationNameData.value = validateName()
        _validationPasswordData.value = validatePassword()
        registerUser()
    }

    private fun registerUser() {
        val validationName = _validationNameData.value
        val validationPassword = _validationPasswordData.value
        _registrationData.value =
            if (validationName == Validation.VALID && validationPassword == Validation.VALID) {
                Registration.POSSIBLE
            } else {
                Registration.IMPOSSIBLE
            }
    }
}
