package com.jonatas.convidados.ui.allGuests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonatas.convidados.R
import com.jonatas.convidados.service.model.GuestModel

class AllGuestAdapter : RecyclerView.Adapter<AllGuestViewHolder>() {

    private var mGuestList: List<GuestModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllGuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(
            R.layout.all_guest_item_adapter,
            parent,
            false
        )

        return AllGuestViewHolder(item)
    }

    override fun getItemCount(): Int {
       return mGuestList.count()
    }

    override fun onBindViewHolder(holder: AllGuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    fun updateGuests(list: List<GuestModel>) {
        mGuestList = list
        notifyDataSetChanged()
    }
}