package com.example.notes3.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.notes3.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeNotes : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // fab
        val fab:FloatingActionButton=view.findViewById(R.id.floatingActionButton)
        fab.setOnClickListener {
            view.findNavController().navigate(R.id.editNotes)
            Log.i("FAB", "boutton fab est appuyer")
        }
    }
}