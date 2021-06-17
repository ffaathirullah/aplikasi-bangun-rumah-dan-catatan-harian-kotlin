package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import org.d3if4203.assesment2.databinding.HalamanDetailCatatanBinding

class HalamanDetailCatatan : Fragment() {
    private val args: HalamanDetailCatatanArgs by navArgs()
    private lateinit var binding: HalamanDetailCatatanBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = HalamanDetailCatatanBinding.inflate(layoutInflater, container, false)
        detailCatatan()
        return binding.root
    }

    fun detailCatatan(){
        binding.textView4.text = args.judul
        binding.textView5.text = args.catatan
    }
}