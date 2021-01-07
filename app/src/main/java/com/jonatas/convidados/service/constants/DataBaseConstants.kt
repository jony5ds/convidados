package com.jonatas.convidados.service.constants

class DataBaseConstants private constructor() {
    object GUEST {
        const val TABLE_NAME = "Guest"

        object COLUMMNS {
            const val ID = "id"
            const val NAME = "name"
            const val Presence = "presence"
        }
    }
}