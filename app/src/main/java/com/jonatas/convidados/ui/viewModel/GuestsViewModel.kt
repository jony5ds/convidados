package com.jonatas.convidados.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jonatas.convidados.service.constants.GuestConstants
import com.jonatas.convidados.service.model.GuestModel
import com.jonatas.convidados.service.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    val mGuestRepository = GuestRepository(application.applicationContext)

    private var mGuestList = MutableLiveData<List<GuestModel>>()
    val guestLits: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int) {
        when (filter) {
            GuestConstants.PRESENT -> mGuestList.value = mGuestRepository.getAllPresents()
            GuestConstants.ABSENT -> mGuestList.value = mGuestRepository.getAllAbsents()
            else -> {
                mGuestList.value = mGuestRepository.getAllGuest()
            }
        }
    }

    fun delete(guest: GuestModel) {
        mGuestRepository.delete(guest)
    }
}