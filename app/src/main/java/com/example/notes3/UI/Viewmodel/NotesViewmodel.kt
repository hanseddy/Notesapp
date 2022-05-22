package com.example.notes3.UI.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class NotesViewmodel(application: Application):AndroidViewModel(application) {
    var Title = MutableLiveData<String>()
    var Desc = MutableLiveData<String>()

    fun setTitle(title:String){
        Title.value=title
    }

    fun setDesc(desc:String){
        Desc.value=desc
    }

}