package com.jonatas.convidados.ui.guestsForm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jonatas.convidados.service.model.GuestModel
import com.jonatas.convidados.service.repository.GuestRepository


class GuestFormViewModel(application : Application): AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository = GuestRepository.getInstance(mContext)

    private val mResult = MutableLiveData<Boolean>()
    val result: LiveData<Boolean> = mResult

    fun save(id: Int, name: String, presence: Boolean){
        val guest = GuestModel(id = id,name = name,presence =  presence)
        if (id == 0) {
            mResult.value =  mGuestRepository.save(guest)
        } else {
            mResult.value =  mGuestRepository.update(guest)
        }
    }

    private val mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest

    fun load(id: Int) {
        mGuest.value = mGuestRepository.findGuestById(id)
    }
}