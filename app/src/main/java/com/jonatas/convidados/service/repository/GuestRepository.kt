package com.jonatas.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.jonatas.convidados.service.constants.DataBaseConstants
import com.jonatas.convidados.service.model.GuestModel
import java.lang.Exception

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper = GuestDataBaseHelper(context = context)

    companion object {
        private lateinit var repository: GuestRepository
        private const val PRESENCE = 1

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestModel): Boolean {
        return try {
            val dataBase = mGuestDataBaseHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMMNS.Presence, guest.presence)
            dataBase.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)

            true

        } catch (e: Exception) {
            false
        }
    }

    fun update(guest: GuestModel): Boolean {
        return try {
            val dataBase = mGuestDataBaseHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMMNS.Presence, guest.presence)

            val selection = DataBaseConstants.GUEST.COLUMMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            dataBase.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues, selection, args)

            true

        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return try {
            val dataBase = mGuestDataBaseHelper.writableDatabase

            val selection = DataBaseConstants.GUEST.COLUMMNS.ID + " = ?"
            val args = arrayOf(id.toString())
            dataBase.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)

            true

        } catch (e: Exception) {
            false
        }
    }

    fun findGuestById(id: Int): GuestModel {
        var guest: GuestModel? = null
        return try {
            val dataBase = mGuestDataBaseHelper.writableDatabase

            val cursor = dataBase.rawQuery(
                "select * from ${DataBaseConstants.GUEST.TABLE_NAME} where id = $id",
                null
            )

            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()
                val name =
                    cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.NAME))
                val presence =
                    (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.Presence)) == PRESENCE)

                guest = GuestModel(id = id, name = name, presence = presence)
            }
            cursor?.close()

            guest!!

        } catch (e: Exception) {
            guest!!
        }

    }

    fun getAllGuest(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return try {
            val dataBase = mGuestDataBaseHelper.readableDatabase

            val cursor = dataBase.rawQuery(
                "select * from ${DataBaseConstants.GUEST.TABLE_NAME}",
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.NAME))
                    val presence =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.Presence)) == PRESENCE)
                    val guest = GuestModel(id = id, name = name, presence = presence)

                    list.add(guest)
                }

            }
            cursor?.close()

            list

        }catch (e: Exception)
        {
            list
        }
    }

    fun getAllPresents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val dataBase = mGuestDataBaseHelper.readableDatabase

            val cursor = dataBase.rawQuery(
                "select * from ${DataBaseConstants.GUEST.TABLE_NAME} where ${DataBaseConstants.GUEST.COLUMMNS.Presence} = 1",
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.NAME))
                    val presence =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.Presence)) == 1)
                    val guest = GuestModel(id = id, name = name, presence = presence)

                    list.add(guest)
                }

            }
            cursor?.close()

            list

        }catch (e: Exception)
        {
            list
        }
    }

    fun getAllAbsents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()

        return try {
            val dataBase = mGuestDataBaseHelper.readableDatabase

            val cursor = dataBase.rawQuery(
                "select * from ${DataBaseConstants.GUEST.TABLE_NAME} where ${DataBaseConstants.GUEST.COLUMMNS.Presence} = 1",
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.NAME))
                    val presence =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMMNS.Presence)) == 1)
                    val guest = GuestModel(id = id, name = name, presence = presence)

                    list.add(guest)
                }

            }
            cursor?.close()

            list

        }catch (e: Exception)
        {
            list
        }
    }
}