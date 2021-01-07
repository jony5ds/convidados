package com.jonatas.convidados.ui.guestsForm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jonatas.convidados.R
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity() {

    private lateinit var mGuestFormViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mGuestFormViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        showResult()

        button_save.setOnClickListener {
            saveGuest()
        }

    }

    private fun saveGuest() {
        val name = edit_name.text.toString()
        val presence = radio_presence.isChecked
        mGuestFormViewModel.save(name, presence)
    }

    private fun showResult() {
        mGuestFormViewModel.result.observe(this, Observer {
            if(it)
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(applicationContext, "Falhou", Toast.LENGTH_SHORT).show()
            finish()
        })
    }
}