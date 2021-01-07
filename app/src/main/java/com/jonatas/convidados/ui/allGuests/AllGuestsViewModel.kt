package com.jonatas.convidados.ui.allGuests

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jonatas.convidados.service.model.GuestModel
import com.jonatas.convidados.service.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private var mGuestList = MutableLiveData<List<GuestModel>>()
    val guestLits: LiveData<List<GuestModel>> = mGuestList

    fun load(){
        mGuestList.value = mGuestRepository.getAllGuest()
    }
}