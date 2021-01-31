package com.jonatas.convidados.service.repository

import android.content.Context
import com.jonatas.convidados.service.model.GuestModel

class GuestRepository (context: Context) {

    //Database Access
    private val mDataBase = GuestDataBase.getDataBase(context).guestDAO()

    // Actions
    fun save(guest: GuestModel): Boolean = mDataBase.save(guest) > 0
    fun update(guest: GuestModel): Boolean = mDataBase.update(guest) > 0
    fun delete(guest: GuestModel) = mDataBase.delete(guest)
    fun findGuestById(id: Int): GuestModel = mDataBase.findGuestById(id)
    fun getAllGuest(): List<GuestModel> = mDataBase.getAllGuest()
    fun getAllPresents(): List<GuestModel> = mDataBase.getAllPresents()
    fun getAllAbsents(): List<GuestModel> = mDataBase.getAllAbsents()
}