package com.jonatas.convidados.ui.allGuests

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jonatas.convidados.R
import com.jonatas.convidados.service.model.GuestModel
import kotlinx.android.synthetic.main.all_guest_item_adapter.view.*

class AllGuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name
    }
}