package by.kleban.myapplication.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kleban.myapplication.R


class SnowdropAddFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_snowdrop_add,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(SnowdropStartViewModel::class.java)
        val edtTextKind = view.findViewById<EditText>(R.id.edt_add_kind)
        val edtTextRef = view.findViewById<EditText>(R.id.edt_add_ref)
        val edtTextDescription = view.findViewById<EditText>(R.id.edt_add_description)
        val buttonAdd = view.findViewById<Button>(R.id.btn_add_snowdrop)

       buttonAdd.setOnClickListener {
           val kind = edtTextKind.text.toString()
           val ref = edtTextRef.text.toString()
           val description = edtTextDescription.text.toString()

           if (kind.isNotEmpty() && ref.isNotEmpty() && description.isNotEmpty()){
           val snowdrop = Snowdrop(kind,ref,description)
           viewModel.addSnowdrop(snowdrop)
           Toast.makeText(requireContext(),"Snowdrop added to collection",Toast.LENGTH_SHORT).show()
           viewModel.changeScreen(Screen.START)}
           else {
               Toast.makeText(requireContext(),"Invalid data",Toast.LENGTH_SHORT).show()
           }
       }

    }
}