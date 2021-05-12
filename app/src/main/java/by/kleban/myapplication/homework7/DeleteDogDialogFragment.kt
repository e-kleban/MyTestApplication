package by.kleban.myapplication.homework7

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.kleban.myapplication.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class DeleteDogDialogFragment : DialogFragment() {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(DogViewModel::class.java)
    }

    companion object{
        const val DELETE="delete"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Delete dog")
            .setMessage("If you want to delete dog from catalog, input dog breed below.")
            .setView(R.layout.fragment_dialog_delete_dog)
            .setPositiveButton("delete", null)
            .setNeutralButton("cancel",null)
            .create()
    }

    override fun onStart() {
        super.onStart()

        val alert = dialog as AlertDialog
        val edtTextBreed= alert.findViewById<EditText>(R.id.edt_delete_breed)

        alert.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
            if (!edtTextBreed?.text.isNullOrEmpty()){
                viewModel.delete(edtTextBreed?.text.toString())
                dismiss()
            }
        }
    }
}