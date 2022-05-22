package com.example.notes3.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.notes3.R
import com.example.notes3.UI.Viewmodel.NotesViewmodel


class EditNotes : Fragment() {

    lateinit var edititles:EditText
    lateinit var editdesc:EditText

    lateinit var validButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model: NotesViewmodel by activityViewModels()
        edititles=view.findViewById(R.id.TitleEdit_id)
        editdesc=view.findViewById(R.id.DescEdit_id)
        validButton= view.findViewById(R.id.valid_button_id)

        edititles.doOnTextChanged { text, start, before, count ->
            if(text.toString().isNotEmpty()){
                validButton.visibility=View.VISIBLE
            }else{
                validButton.visibility=View.GONE
            }
        }

        validButton.setOnClickListener {
            val mTitle=edititles.text.toString()
            val mDesc=editdesc.text.toString()
            model.setTitle(mTitle)
            model.setDesc(mDesc)
            Log.i("notesAdded","la valeur du titre est "+edititles.text.toString()+" et "+editdesc.text.toString())
            //Toast.makeText(context,"successfully added", Toast.LENGTH_LONG).show()
            //view.findNavController().navigate(R.id.homeNotes)
            val action= EditNotesDirections.actionEditNotesToHomeNotes(mTitle,mDesc)
            view.findNavController().navigate(action)
        }


    }
}