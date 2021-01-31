package com.jonatas.convidados.service.repository

import androidx.room.*
import com.jonatas.convidados.service.model.GuestModel

@Dao
interface GuestDAO {
    @Insert
    fun save(guest: GuestModel) : Long
    @Update
    fun update(guest: GuestModel) : Int
    @Delete
    fun delete(guest: GuestModel)
    @Query("SELECT * FROM Guest WHERE id = :id")
    fun findGuestById(id: Int): GuestModel
    @Query("SELECT * FROM Guest")
    fun getAllGuest(): List<GuestModel>
    @Query("SELECT * FROM Guest WHERE presence = 1")
    fun getAllPresents(): List<GuestModel>
    @Query("SELECT * FROM Guest WHERE presence = 0")
    fun getAllAbsents(): List<GuestModel>
}