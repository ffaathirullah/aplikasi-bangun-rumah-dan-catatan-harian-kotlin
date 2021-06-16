package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if4203.assesment2.R
import org.d3if4203.assesment2.databinding.FragmentEditBinding
import org.d3if4203.assesment2.db.Catatan
import org.d3if4203.assesment2.db.CatatanDB

class HalamanEdit : Fragment() {

    private val db by lazy { this.getContext()?.let { CatatanDB(it) } }
    private var catatanId = 0

    private lateinit var binding: FragmentEditBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentEditBinding.inflate(layoutInflater, container, false)
        setupLstener()
        return binding.root
    }

    private fun setupLstener(){
        binding.btnSave.setOnClickListener {view: View ->
            CoroutineScope(Dispatchers.IO).launch {
                db?.catatanDao()?.addCatatan(
                    Catatan(
                        0,
                        binding.editTitle.text.toString(),
                        binding.editCatatan.text.toString()
                    )
                )
            }
            view.findNavController().navigate(R.id.action_halamanEdit_to_halamanCatatan)
        }
    }
}