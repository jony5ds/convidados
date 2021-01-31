package com.jonatas.convidados.listerner

import com.jonatas.convidados.service.model.GuestModel

interface GuestListener {
    fun onclick(id: Int)
    fun onDelete(guest: GuestModel)
}