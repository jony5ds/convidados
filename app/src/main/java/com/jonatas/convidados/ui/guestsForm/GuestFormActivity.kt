package com.jonatas.convidados.ui.guestsForm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jonatas.convidados.R
import com.jonatas.convidados.service.constants.GuestConstants
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity() {

    private lateinit var mGuestFormViewModel: GuestFormViewModel
    private var mGuestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mGuestFormViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListners()
        observe()
        loadData()
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle!= null)
        {
            mGuestId = bundle.getInt(GuestConstants.GUESTID)
            mGuestFormViewModel.load(mGuestId)
        }
    }

    private fun setListners() {
        button_save.setOnClickListener {
            saveGuest()
        }
    }

    private fun saveGuest() {
        val name = edit_name.text.toString()
        val presence = radio_presence.isChecked
        mGuestFormViewModel.save(mGuestId,name, presence)
    }

    private fun observe() {
        mGuestFormViewModel.result.observe(this, Observer {
            if(it)
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(applicationContext, "Falhou", Toast.LENGTH_SHORT).show()
            finish()
        })

        mGuestFormViewModel.guest.observe(this, Observer {
            edit_name.setText(it.name)
            if (it.presence) {
                radio_presence.isChecked = true
            } else {
                radio_absent.isChecked = true
            }
        })
    }
}