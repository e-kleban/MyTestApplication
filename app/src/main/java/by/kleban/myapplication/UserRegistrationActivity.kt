package by.kleban.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout

class UserRegistrationActivity : AppCompatActivity() {

    val viewModel by lazy {
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
            when (validation) {
                Validation.EMPTY -> {
                    textInputLayoutName.isErrorEnabled = true
                    textInputLayoutName.error = getString(R.string.error_empty_name)
                }
                Validation.VALID -> {
                    textInputLayoutName.isErrorEnabled = false
                }
            }
        }

        viewModel.validationPasswordData.observe(this) { validation ->
            when (validation) {
                Validation.EMPTY -> {
                    textInputLayoutPassword.isErrorEnabled = true
                    textInputLayoutPassword.error = getString(R.string.error_empty_password)
                }
                Validation.VALID -> {
                    textInputLayoutPassword.isErrorEnabled = false
                }
            }
        }

        buttonCreateUser.setOnClickListener {
            viewModel.registration()
        }


    }


}


//if (it?.toString().isNullOrEmpty()) {
//    textInputLayoutName.isErrorEnabled = true
//    textInputLayoutName.error = getString(R.string.error_empty_name)
//} else {
//    textInputLayoutName.error = null
//}