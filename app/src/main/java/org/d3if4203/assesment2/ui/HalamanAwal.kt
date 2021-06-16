package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.d3if4203.assesment2.R
import org.d3if4203.assesment2.databinding.FragmentHalaman1Binding

class HalamanAwal : Fragment() {
    private lateinit var binding: FragmentHalaman1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHalaman1Binding.inflate(layoutInflater, container, false)
        nextHalaman()
        return binding.root
    }
    fun nextHalaman (){
        binding.btnNext.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_halamanAwal_to_halamanCatatan)
        }
    }

}