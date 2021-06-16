package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.d3if4203.assesment2.R
import org.d3if4203.assesment2.databinding.FragmentCatatanBinding

class HalamanCatatan : Fragment() {
    private lateinit var binding: FragmentCatatanBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentCatatanBinding.inflate(layoutInflater, container, false)
        nextHalaman()
        return binding.root
    }
    fun nextHalaman (){
        binding.btnBuat.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_halamanCatatan_to_halamanEdit)
        }
    }

}