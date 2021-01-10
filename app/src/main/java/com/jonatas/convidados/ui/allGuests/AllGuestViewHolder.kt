package com.jonatas.convidados.ui.allGuests

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jonatas.convidados.R
import com.jonatas.convidados.listerner.GuestListener
import com.jonatas.convidados.service.model.GuestModel
import kotlinx.android.synthetic.main.all_guest_item_adapter.view.*

class AllGuestViewHolder(itemView: View, private val listener: GuestListener) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name
        textName.setOnClickListener {
            listener.onclick(guest.id)
        }

        textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, i ->
                    listener.onDelete(guest.id)
                }
                .setNegativeButton(R.string.cancelar, null)
                .show()
            true
        }
    }
}