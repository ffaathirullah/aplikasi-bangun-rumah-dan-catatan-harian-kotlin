package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if4203.assesment2.databinding.FragmentCatatanBinding

class HalamanCatatan : Fragment() {
    private lateinit var binding: FragmentCatatanBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentCatatanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}