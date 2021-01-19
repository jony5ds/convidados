package com.jonatas.convidados.ui.absents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jonatas.convidados.R
import com.jonatas.convidados.ui.viewModel.GuestsViewModel

class AbsentFragment : Fragment() {

  private lateinit var absentViewModel: GuestsViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    absentViewModel =
            ViewModelProvider(this).get(GuestsViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_absent, container, false)

    return root
  }
}