package com.jonatas.convidados.ui.allGuests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jonatas.convidados.R


class AllGuestsFragment : Fragment() {

    private lateinit var allGuestsViewModel: AllGuestsViewModel
    private val mAllGuestAdapter = AllGuestAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allGuestsViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all_guests, container, false)

        // Obter recyclerView
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        // Definir Layout
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Definir Adapter
        recyclerView.adapter = mAllGuestAdapter

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        allGuestsViewModel.load()
    }

    private fun observer() {
        allGuestsViewModel.guestLits.observe(viewLifecycleOwner, Observer {
            mAllGuestAdapter.updateGuests(it)
        })
    }
}