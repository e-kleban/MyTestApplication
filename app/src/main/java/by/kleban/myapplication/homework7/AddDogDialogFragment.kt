package by.kleban.myapplication.homework7

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import by.kleban.myapplication.R
import by.kleban.myapplication.homework7.database.entity.Dog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout


class AddDogDialogFragment : DialogFragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(DogViewModel::class.java)
    }

    companion object {
        const val TAG = "tag"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Input data of dog")
            .setView(R.layout.fragment_dialog_add_dog)
            .setPositiveButton("Save", null)
            .create()
    }

    override fun onStart() {
        super.onStart()

        val alert = dialog as AlertDialog
        val inputBreed = alert.findViewById<TextInputLayout>(R.id.input_breed_dog)
        val inputRef = alert.findViewById<TextInputLayout>(R.id.input_ref_dog)
        val inputDescription = alert.findViewById<TextInputLayout>(R.id.input_description_dog)

        alert.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
            if (isEmptyOrNull(inputBreed) &&
                isEmptyOrNull(inputRef) &&
                isEmptyOrNull(inputDescription)
            ) {
                val newDog = createDog(inputBreed, inputRef, inputDescription)
                viewModel.addDog(newDog)
                dismiss()
            }
        }
    }

    private fun isEmptyOrNull(textInputLayout: TextInputLayout?): Boolean {
        return if (textInputLayout?.editText?.text.isNullOrEmpty()) {
            textInputLayout?.error = "Text cannot be null or empty"
            textInputLayout?.isErrorEnabled = true
            false
        } else true
    }

    private fun createDog(
        textInputBreed: TextInputLayout?,
        textInputRef: TextInputLayout?,
        textInputDescription: TextInputLayout?
    ): Dog {
        return Dog(
            textInputBreed?.editText?.text.toString(),
            textInputRef?.editText?.text.toString(),
            textInputDescription?.editText?.text.toString(),
        )
    }
}