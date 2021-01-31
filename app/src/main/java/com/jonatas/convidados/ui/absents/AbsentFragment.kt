package com.jonatas.convidados.ui.absents

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonatas.convidados.R
import com.jonatas.convidados.listerner.GuestListener
import com.jonatas.convidados.service.constants.GuestConstants
import com.jonatas.convidados.service.model.GuestModel
import com.jonatas.convidados.ui.adapter.AllGuestAdapter
import com.jonatas.convidados.ui.guestsForm.GuestFormActivity
import com.jonatas.convidados.ui.viewModel.GuestsViewModel
import kotlinx.android.synthetic.main.fragment_absent.*

class AbsentFragment : Fragment() {

    private lateinit var mViewModel: GuestsViewModel
    private val mAdapter = AllGuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_absent, container, false)
        listerner()
        mAdapter.attachListener(mListener)
        obeserver()
        return root
    }

    private fun obeserver() {
        mViewModel.guestLits.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }

    private fun listerner() {
        mListener = object : GuestListener {
            override fun onclick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUESTID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(guest: GuestModel) {
                mViewModel.delete(guest)
                mViewModel.load(GuestConstants.ABSENT)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(recycler_all_absents) {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load(GuestConstants.ABSENT)
    }
}