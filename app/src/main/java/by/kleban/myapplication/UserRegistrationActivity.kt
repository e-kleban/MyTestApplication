package by.kleban.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

class UserRegistrationActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(UserRegistrationViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration)

        val textInputLayoutName = findViewById<TextInputLayout>(R.id.txt_input_layout_user_name)
        val textInputLayoutPassword = findViewById<TextInputLayout>(R.id.txt_input_layout_password)
        val buttonCreateUser = findViewById<Button>(R.id.btn_create_account)

        textInputLayoutName.editText?.setText(viewModel.userNameData.value)
        textInputLayoutPassword.editText?.setText(viewModel.passwordData.value)

        textInputLayoutName.editText?.addTextChangedListener {
            viewModel.changeName(it.toString())
        }

        textInputLayoutPassword.editText?.addTextChangedListener {
            viewModel.changePassword(it.toString())
        }

        viewModel.validationNameData.observe(this) { validation ->
            checkValidationName(validation, textInputLayoutName)
        }

        viewModel.validationPasswordData.observe(this) { validation ->
            checkValidationPassword(validation, textInputLayoutPassword)
        }

        buttonCreateUser.setOnClickListener {
            viewModel.registration()
        }

        viewModel.registrationData.observe(this) { registration ->
            if (registration == Registration.POSSIBLE) {
                val registeredName = viewModel.userNameData.value
                if (registeredName != null) {
                    createAlertDialog(registeredName)
                }
            }
        }
    }

    private fun checkValidationName(validation: Validation, textInputLayoutName: TextInputLayout) {
        when (validation) {
            Validation.EMPTY -> {
                textInputLayoutName.isErrorEnabled = true
                textInputLayoutName.error = getString(R.string.error_empty_field)
            }
            else -> {
                textInputLayoutName.isErrorEnabled = false
            }
        }
    }

    private fun checkValidationPassword(
        validation: Validation,
        textInputLayoutPassword: TextInputLayout
    ) {
        when (validation) {
            Validation.EMPTY -> {
                textInputLayoutPassword.isErrorEnabled = true
                textInputLayoutPassword.error = getString(R.string.error_empty_field)
            }
            Validation.VALID -> {
                textInputLayoutPassword.isErrorEnabled = false
            }
            Validation.TOO_MANY_SYMBOLS -> {
                textInputLayoutPassword.isErrorEnabled = true
                textInputLayoutPassword.error = getString(R.string.error_many_symbols)
            }
        }
    }

    private fun createAlertDialog(registeredName: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.dialog_title_great)
            .setMessage(R.string.dialog_message)
            .setCancelable(true)
            .setNegativeButton(R.string.btn_ok) { dialog, id ->
                dialog.dismiss()
            }
            .setPositiveButton(R.string.btn_enter) { dialog, id ->
                val intent = WelcomeActivity.newIntent(this, registeredName)
                startActivity(intent)
            }.show()
    }
}