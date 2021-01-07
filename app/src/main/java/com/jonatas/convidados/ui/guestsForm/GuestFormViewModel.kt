package com.jonatas.convidados.ui.guestsForm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jonatas.convidados.service.model.GuestModel
import com.jonatas.convidados.service.repository.GuestRepository


class GuestFormViewModel(application : Application): AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mResult = MutableLiveData<Boolean>()
    val result: LiveData<Boolean> = mResult

    private val mGuestRepository = GuestRepository.getInstance(mContext)

    fun save(name: String, presence: Boolean){
        val guest = GuestModel(name = name,presence =  presence)
       mResult.value =  mGuestRepository.save(guest)

    }
}