package com.jonatas.convidados.ui.presents

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonatas.convidados.R
import com.jonatas.convidados.listerner.GuestListener
import com.jonatas.convidados.service.constants.GuestConstants
import com.jonatas.convidados.ui.allGuests.AllGuestAdapter
import com.jonatas.convidados.ui.guestsForm.GuestFormActivity
import com.jonatas.convidados.ui.viewModel.GuestsViewModel
import kotlinx.android.synthetic.main.fragment_all_guests.*
import kotlinx.android.synthetic.main.fragment_present.*

class PresentFragment : Fragment() {

  private lateinit var mViewModel: GuestsViewModel
  private val mAllGuestAdapter = AllGuestAdapter()
  private lateinit var mListener: GuestListener

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    mViewModel =
            ViewModelProvider(this).get(GuestsViewModel::class.java)

    val root = inflater.inflate(R.layout.fragment_present, container, false)

    mListener = object: GuestListener {
      override fun onclick(id: Int) {
        val intent = Intent(context, GuestFormActivity::class.java)
        val bundle = Bundle()
        bundle.putInt(GuestConstants.GUESTID,id)
        intent.putExtras(bundle)
        startActivity(intent)
      }

      override fun onDelete(id: Int) {
        mViewModel.delete(id)
        mViewModel.load(GuestConstants.PRESENT)
      }
    }
    mAllGuestAdapter.attachListener(mListener)

    observer()

    return root
  }

  override fun onResume() {
    super.onResume()
    mViewModel.load(GuestConstants.PRESENT)
  }

  private fun observer() {
    mViewModel.guestLits.observe(viewLifecycleOwner, Observer {
      mAllGuestAdapter.updateGuests(it)
    })
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    with(recycler_presents) {
      layoutManager = LinearLayoutManager(context)
      adapter = mAllGuestAdapter
    }
  }
}