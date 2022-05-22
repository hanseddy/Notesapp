package com.example.notes3.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes3.R
import com.example.notes3.UI.Viewmodel.NotesViewmodel
import com.example.notes3.UI.Viewmodel.VM_adapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeNotes : Fragment() {

    lateinit var notesadapter:VM_adapter
    var mTitle= ArrayList<String>()
    var mDesc= ArrayList<String>()
    lateinit var mTitleData:String
    lateinit var mDescData:String
    var i: Int=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewmodel
        val model: NotesViewmodel by activityViewModels()
        //val model= ViewModelProvider(this).get(NotesViewmodel::class.java)
        // fab
        val fab:FloatingActionButton=view.findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            view.findNavController().navigate(R.id.editNotes)
            Log.i("FAB", "boutton fab est appuyer")
        }

        mTitleData= model.Title.value.toString()
        mDescData= model.Desc.value.toString()

        mTitle.add(mTitleData)
        mDesc.add(mDescData)

        val recycler = view.findViewById<RecyclerView>(R.id.Recycler_id)
        recycler.layoutManager= LinearLayoutManager(context)
        notesadapter=VM_adapter(mTitle,mDesc)
        recycler.adapter=notesadapter
        //}
    }
}