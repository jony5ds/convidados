package com.jonatas.convidados.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonatas.convidados.R
import com.jonatas.convidados.listerner.GuestListener
import com.jonatas.convidados.service.model.GuestModel

class AllGuestAdapter : RecyclerView.Adapter<AllGuestViewHolder>() {

    private var mGuestList: List<GuestModel> = arrayListOf()
    private lateinit var mListener: GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllGuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(
            R.layout.all_guest_item_adapter,
            parent,
            false
        )
        return AllGuestViewHolder(item, mListener)
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

    fun attachListener(listener: GuestListener) {
        mListener = listener
    }
}