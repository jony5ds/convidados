package com.jonatas.convidados.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Guest")
class GuestModel {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var name = ""
    var presence = true
}
