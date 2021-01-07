package com.jonatas.convidados.service.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.jonatas.convidados.service.constants.DataBaseConstants

class GuestDataBaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATA_BASE_NAME,
    null,
    DATA_BASE_VERSION
) {
    override fun onCreate(dataBase: SQLiteDatabase?) {
        dataBase?.execSQL(CREATE_TABLE_GUEST)
    }

    override fun onUpgrade(dataBase: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DATA_BASE_VERSION = 1
        private const val DATA_BASE_NAME = "Guest.db"

        private const val CREATE_TABLE_GUEST =
            ("create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
                    + DataBaseConstants.GUEST.COLUMMNS.ID + " integer primary key autoincrement, "
                    + DataBaseConstants.GUEST.COLUMMNS.NAME + " text, "
                    + DataBaseConstants.GUEST.COLUMMNS.Presence + " integer);")

    }
}