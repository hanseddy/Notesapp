package com.example.notes3.UI.Viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes3.R

class VM_adapter: RecyclerView.Adapter<VM_adapter.NotesViewholder>(){
    var updateTitle:String=""
    var updateDesc:String=""

    class NotesViewholder(view: View):RecyclerView.ViewHolder(view) {
        val notes_Title: TextView
        val notes_Desc: TextView
        val notes_Dates: TextView

        init {
            notes_Title = view.findViewById(R.id.Title_text)
            notes_Desc = view.findViewById(R.id.Description_temp_id)
            notes_Dates = view.findViewById(R.id.Date_temp_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewholder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_base_layout,parent,false)

        return NotesViewholder(view)
    }

    override fun onBindViewHolder(holder: NotesViewholder, position: Int) {
        holder.notes_Title.text= updateTitle
        holder.notes_Desc.text=updateDesc
    }

    override fun getItemCount(): Int = updateTitle.length

    fun setData(title:String,desc:String){
        this.updateTitle = title
        this.updateDesc = desc
    }

}