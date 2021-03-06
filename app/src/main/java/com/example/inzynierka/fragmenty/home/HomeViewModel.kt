package com.example.inzynierka.fragmenty.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.inzynierka.data.Pack
import com.example.inzynierka.fragmenty.Send.Send
import com.example.inzynierka.fragmenty.repository.FirebaseRepository

class HomeViewModel : ViewModel() {
    private val repository = FirebaseRepository()
    var pack = MutableLiveData<Pack>()

    fun getPackData(Id_pack: String): LiveData<Pack>
    {
        pack = repository.getPackData(Id_pack) as MutableLiveData<Pack>

        return pack
    }

    fun sendInfotoUser(Id_pack: String, uid: String)
    {
        repository.sendInfoToUser(Id_pack, uid)
    }
}